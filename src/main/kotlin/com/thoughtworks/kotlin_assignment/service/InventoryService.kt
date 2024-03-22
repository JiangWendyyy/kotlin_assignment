package com.thoughtworks.kotlin_assignment.service

import com.thoughtworks.kotlin_assignment.Entity.*
import com.thoughtworks.kotlin_assignment.RetrofitClient
import com.thoughtworks.kotlin_assignment.apiInterface.InventoryApi

class InventoryService {

    private val retrofit = RetrofitClient.getInstance()
    private val inventoryService = retrofit.create(InventoryApi::class.java)
    suspend fun getAllInventories():List<Inventory> {
        // 发起 GET 请求获取库存列表
        val allInventories = inventoryService.getAllInventories()
        if (allInventories.isSuccessful) {
            val inventories = allInventories.body()
            if (!inventories.isNullOrEmpty()) {
                println(inventories.toString())
                return inventories
            }
        } else {
            println("http error")
        }
        return emptyList()
    }
}
