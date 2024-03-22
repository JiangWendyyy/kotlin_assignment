package com.thoughtworks.kotlin_assignment.Entity

class NormalProduct(
    override val id: String,
    override val SKU: String,
    override val name: String,
    override val price: Double,
    override val type: String,
    override val image: String,
    private var inventories:List<Inventory>
) : Product(id,SKU, name, price, type,image) {
    fun displayProductDetails():String{
        val price = calculatePrice()
        val inventory = getInventory()
        return "普通商品$id:sku为：$SKU,价格为：$price,库存为：$inventory"
    }
    override fun calculatePrice(): Double = this.price
    override fun getInventory(): Int = this.inventories.sumOf { it.quantity }

    fun setInventoryList(inventoryList:List<Inventory>){
        this.inventories = inventoryList
    }
}
