package com.thoughtworks.kotlin_assignment

import com.thoughtworks.kotlin_assignment.Entity.HighDemandProduct
import com.thoughtworks.kotlin_assignment.Entity.Inventory
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HighDemandProductTest1{


    @Test
    fun `displayProductDetails`(){
        var products = givenProductList()
        val result1 = products[0].displayProductDetails()
        val result2 = products[1].displayProductDetails()
        val result3 = products[2].displayProductDetails()
        println(result1)
        println(result2)
        println(result3)
        assertTrue(result1.contentEquals("稀缺商品1:sku为：ABC1,价格为：450.0,库存为：30"))
        assertTrue(result2.contentEquals("稀缺商品2:sku为：ABC2,价格为：360.0,库存为：100"))
        assertTrue(result3.contentEquals("稀缺商品3:sku为：ABC3,价格为：300.0,库存为：110"))
    }
    private fun givenProductList():List<HighDemandProduct> {
        val inventories1 = listOf(
            Inventory("1","ABC1","CN_NORTH",20),
            Inventory("1","ABC123","US_WEST",10)
        )
        val inventories2 = listOf(
            Inventory("2","ABC2","CN_NORTH",50),
            Inventory("1","ABC123","US_WEST",50)
        )
        val inventories3 = listOf(
            Inventory("3","ABC3","CN_NORTH",60),
            Inventory("1","ABC123","US_WEST",50)
        )
        return listOf(
            HighDemandProduct(1, "ABC1", "Electronic Watch", 300.00, "HIGH_DEMAND", "image2.jpg", inventories1),
            HighDemandProduct(2, "ABC2", "Electronic Watch", 300.00, "HIGH_DEMAND", "image2.jpg", inventories2),
                HighDemandProduct(
                    3,
                    "ABC3",
                    "Electronic Watch",
                    300.00,
                    "HIGH_DEMAND",
                    "image2.jpg",
                    inventories3)
        )
    }
}
