package com.thoughtworks.kotlin_assignment

private const val ORIGINAL_PRICE_INVENTORY = 100
private const val PERCENT_30_UP_PRICE_INVENTORY = 30

class HighDemandProduct(
    override val id: String,
    override val SKU: String,
    override val name: String,
    override val price: Double,
    override val type: String,
    override val image: String,
    private var inventories: List<Inventory>,
) : Product(id,SKU, name, price, type,image) {
    override fun displayProductDetails():String{
        val price = calculatePrice()
        val inventory = getInventory()
        return "稀缺商品$id:sku为：$SKU,价格为：$price,库存为：$inventory"
    }
    override fun calculatePrice(): Double{
        val inventory = this.getInventory()
        return when{
            inventory > ORIGINAL_PRICE_INVENTORY -> price
            inventory in (PERCENT_30_UP_PRICE_INVENTORY+1 )..ORIGINAL_PRICE_INVENTORY -> this.price * 1.2
            inventory <= PERCENT_30_UP_PRICE_INVENTORY -> price * 1.5
            else -> {price}
        }
    }
    override fun getInventory(): Int = this.inventories.sumOf { it.quantity }

    fun setInventoryList(inventoryList:List<Inventory>){
        this.inventories = inventoryList
    }
}
