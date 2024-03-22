package com.thoughtworks.kotlin_assignment

abstract class Product (
    open val id: String,
    open val SKU: String,
    open val name: String,
    open val price: Double,
    open val type: String,
    open val image: String
){
    abstract fun displayProductDetails(): String
}
