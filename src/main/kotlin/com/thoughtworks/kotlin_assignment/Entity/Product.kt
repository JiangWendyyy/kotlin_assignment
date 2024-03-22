package com.thoughtworks.kotlin_assignment.Entity

open class Product (
    open val id: Int,
    open val SKU: String,
    open val name: String,
    open var price: Double,
    open val type: String,
    open val image: String
){
    open fun displayProductDetails() = "$type 商品 id为 $id,sku为：$SKU,名称为：$name,价格为：$price,图片为：$image"
}
