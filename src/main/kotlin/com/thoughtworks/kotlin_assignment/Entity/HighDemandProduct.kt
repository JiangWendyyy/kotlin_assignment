package com.thoughtworks.kotlin_assignment.Entity

private const val ORIGINAL_PRICE_INVENTORY = 100
private const val PERCENT_30_UP_PRICE_INVENTORY = 30

class HighDemandProduct(
    override val id: Int,
    override val SKU: String,
    override val name: String,
    override var price: Double,
    override val type: String = "HIGH_DEMAND",
    override val image: String
) : Product(id,SKU, name, price, type,image) {
    private var inventories: List<Inventory> = emptyList()
    override fun displayProductDetails():String{
        val inventory = getInventory()
        return super.displayProductDetails()+"库存为：$inventory"
    }
    fun calculatePrice(){
        val inventory = this.getInventory()
        val price: Double = when {
            inventory > ORIGINAL_PRICE_INVENTORY -> price
            inventory in (PERCENT_30_UP_PRICE_INVENTORY + 1)..ORIGINAL_PRICE_INVENTORY -> this.price * 1.2
            inventory <= PERCENT_30_UP_PRICE_INVENTORY -> price * 1.5
            else -> {
                price
            }
        }
        this.price = price
    }
    private fun getInventory(): Int {
        if(inventories.isEmpty()){
            return 0
        }
        return this.inventories.sumOf { it.quantity }
    }

    fun setInventoryList(inventoryList:List<Inventory>){
        this.inventories = inventoryList
    }
}
