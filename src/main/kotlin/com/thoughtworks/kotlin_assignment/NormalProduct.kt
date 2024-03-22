package com.thoughtworks.kotlin_assignment

class NormalProduct(
    override val id: String,
    override val SKU: String,
    override val name: String,
    override val price: Double,
    override val type: String,
    override val image: String
) : Product(id,SKU, name, price, type,image) {
    override fun displayProductDetails()="普通商品$id:sku为：$SKU,价格为：$price"
}
