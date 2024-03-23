package com.thoughtworks.kotlin_assignment.service

import com.thoughtworks.kotlin_assignment.Entity.*
import com.thoughtworks.kotlin_assignment.RetrofitClient
import com.thoughtworks.kotlin_assignment.apiInterface.ProductApi

private const val NORMAL_TYPE = "NORMAL"

private const val HIGH_DEMAND_TYPE = "HIGH_DEMAND"

class ProductService {

    private val retrofit = RetrofitClient.getInstance()
    private val productService = retrofit.create(ProductApi::class.java)
    suspend fun getAllProducts():List<Product>{
        // 发起 GET 请求获取产品列表
        val allDataProducts = productService.getAllProducts()
        if (productService.getAllProducts().isSuccessful) {
            val body = allDataProducts.body()
            if (!body.isNullOrEmpty()) {
                return convertToProduct(body)
            }
        } else {
            println("http error")
        }
        return emptyList()
    }

    fun setHighDemandProductsPrice(products: List<Product>) {
        val highDemandProducts = products.filterIsInstance<HighDemandProduct>()
        highDemandProducts.forEach {
            val calculatePrice = it.calculatePrice()
            it.setCalculatedPrice(calculatePrice)
        }
    }

    fun setProductsPrice(products: List<Product>) {
        products.forEach {
            val calculatePrice = it.calculatePrice()
            it.setCalculatedPrice(calculatePrice)
        }
    }

    fun setProductInventory(inventories:List<Inventory>,products: List<Product>):List<Product> {
        val inventoryMap: Map<String, List<Inventory>> = inventories.groupBy { it.SKU }
        products.forEach {
            inventoryMap[it.SKU]?.let { product -> it.setInventoryList(product) }
        }
        return products
    }

    private fun convertToProduct(dataProduct: List<DataProduct>): List<Product> {
        return dataProduct.map {
            val product = when (it.type) {
                NORMAL_TYPE -> NormalProduct(
                    id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = NORMAL_TYPE
                )

                HIGH_DEMAND_TYPE -> HighDemandProduct(
                    id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = HIGH_DEMAND_TYPE
                )

                else -> Product(
                    id = it.id, SKU = it.SKU, name = it.name, price = it.price, image = it.image, type = it.type
                )
            }
            product
        }.toList()
    }

    fun display(products: List<Product>) {
        for (product in products) {
            println(product.displayProductDetails())
        }
    }
}


