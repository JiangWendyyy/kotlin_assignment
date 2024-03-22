package com.thoughtworks.kotlin_assignment.Entity

open class Product (
    open val id: String,
    open val SKU: String,
    open val name: String,
    open val price: Double,
    open val type: String,
    open val image: String
){
    open fun calculatePrice(): Double = price

    open fun getInventory(): Int = 0
}
