package com.thoughtworks.kotlin_assignment.Entity

class NormalProduct(
    override val id: Int,
    override val SKU: String,
    override val name: String,
    override var price: Double,
    override val type: String = "NORMAL",
    override val image: String,
) : Product(id,SKU, name, price, type,image) {
    private var inventories: List<Inventory> = emptyList()
    override fun displayProductDetails():String{
        var superDetail = super.displayProductDetails()
        val inventory = getInventory()
        return superDetail+"库存为：$inventory"
    }
    private fun getInventory(): Int = this.inventories.sumOf { it.quantity }
}
