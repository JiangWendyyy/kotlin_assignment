package com.thoughtworks.kotlin_assignment

import com.thoughtworks.kotlin_assignment.Entity.Inventory
import com.thoughtworks.kotlin_assignment.Entity.NormalProduct
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NormalProductTest{


    @Test
    fun `display product details`(){
        val product = givenProduct()
        val result = product.displayProductDetails()
        println(result)
        assertTrue(result.contentEquals("NORMAL 商品 id为 1,sku为：ABC123,名称为：Electronic Watch,价格为：299.99,图片为：image2.jpg,库存为：200"))
    }
    private fun givenProduct(): NormalProduct {
        val inventories = listOf(
            Inventory("1","ABC123","CN_NORTH",120),
            Inventory("1","ABC123","US_WEST",80)
        )
        return NormalProduct(1, "ABC123", "Electronic Watch", 299.99, "NORMAL", "image2.jpg", inventories)
    }
}
