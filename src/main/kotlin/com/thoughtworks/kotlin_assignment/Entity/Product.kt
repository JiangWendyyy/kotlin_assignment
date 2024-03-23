package com.thoughtworks.kotlin_assignment.Entity

open class Product (
    open val id: Int,
    open val SKU: String,
    open val name: String,
    open var price: Double,
    open val type: String,
    open val image: String,
    open var inventories: List<Inventory> = emptyList()
){
    open fun displayProductDetails():String{
        var inventory = getInventory()
        return "$type 商品 id为 $id,sku为：$SKU,名称为：$name,价格为：$price,图片为：$image,库存为：$inventory"
    }

    open fun getInventory(): Int = this.inventories.sumOf { it.quantity }
    open fun calculatePrice():Double = price

    fun setInventoryList(inventoryList:List<Inventory>){
        this.inventories = inventoryList
    }
    open fun setCalculatedPrice(calculatePrice: Double) {
        this.price = calculatePrice
    }
}
