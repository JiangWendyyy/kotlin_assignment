package com.thoughtworks.kotlin_assignment.apiInterface

import com.thoughtworks.kotlin_assignment.Entity.Inventory
import retrofit2.Response
import retrofit2.http.GET


interface InventoryApi {
    @GET("inventories/")
    suspend fun getAllInventories(): Response<List<Inventory>>
}
