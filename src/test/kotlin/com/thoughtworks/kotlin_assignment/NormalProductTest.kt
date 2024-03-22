package com.thoughtworks.kotlin_assignment

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class NormalProductTest{


    @Test
    fun `displayProductDetails`(){
        var product = givenProduct()
        val result = product.displayProductDetails()
        println(result)
        assertTrue(result.contentEquals("普通商品1:sku为：ABC123,价格为：299.99,库存为：200"))
    }
    private fun givenProduct():NormalProduct {
        val inventories = listOf(Inventory("1","ABC123","CN_NORTH",120),
            Inventory("1","ABC123","US_WEST",80))
        return NormalProduct("1", "ABC123", "Electronic Watch", 299.99, "NORMAL", "image2.jpg", inventories)
    }
}
