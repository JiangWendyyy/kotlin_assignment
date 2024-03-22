package com.thoughtworks.kotlin_assignment.Entity

data class DataProduct (
    val id: Int,
    val SKU: String,
    val name: String,
    var price: Double,
    val type: String,
    val image: String
)
