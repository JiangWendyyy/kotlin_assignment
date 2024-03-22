package com.thoughtworks.kotlin_assignment.Entity

class Inventory(
    val id: String,
    val SKU: String,
    val zone: String,
    val quantity: Int
){
override fun toString() ="id:$id,SKU:$SKU,zone:$zone,quantity:$quantity\n"}
