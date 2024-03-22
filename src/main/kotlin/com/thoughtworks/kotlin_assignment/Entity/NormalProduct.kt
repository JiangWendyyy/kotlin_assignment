package com.thoughtworks.kotlin_assignment.Entity


class NormalProduct(
    override val id: Int,
    override val SKU: String,
    override val name: String,
    override var price: Double,
    override val type: String,
    override val image: String,
    override var inventories: List<Inventory> = emptyList()
) : Product(id,SKU, name, price, type,image)
