package com.thoughtworks.kotlin_assignment.service

import com.thoughtworks.kotlin_assignment.Entity.HighDemandProduct
import com.thoughtworks.kotlin_assignment.Entity.Inventory
import com.thoughtworks.kotlin_assignment.Entity.NormalProduct
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductServiceTest{

    private var productService = ProductService()
    @Test
    fun `check set inventories and price`() {
        val inventories = givenInventories()
        val products = givenProducts()
        val haveSetInventoryProducts = productService.setProductInventory(inventories, products)
        assertEquals(30, haveSetInventoryProducts[0].getInventory())
        assertEquals(100,haveSetInventoryProducts[1].getInventory())
        assertEquals(50,haveSetInventoryProducts[2].getInventory())
        productService.setHighDemandProductsPrice(products)
        assertEquals(450.0, haveSetInventoryProducts[0].price)
        assertEquals(360.0,haveSetInventoryProducts[1].price)
        assertEquals(300.0,haveSetInventoryProducts[2].price)
    }
    private fun givenInventories() = listOf(
        Inventory("1","ABC1","CN_NORTH",20),
        Inventory("2","ABC1","US_WEST",10),
        Inventory("3","ABC2","CN_NORTH",50),
        Inventory("4","ABC2","US_WEST",50),
        Inventory("5","DEF123","US_WEST",50)
    )
    private fun givenProducts() = listOf(
            HighDemandProduct(1, "ABC1", "Electronic Watch", 300.00, "HIGH_DEMAND", "image2.jpg"),
            HighDemandProduct(2, "ABC2", "apple Watch", 300.00, "HIGH_DEMAND", "image2.jpg"),
            NormalProduct(3, "DEF123", "Banana Watch", 300.00, "HIGH_DEMAND", "image2.jpg")
    )
}
