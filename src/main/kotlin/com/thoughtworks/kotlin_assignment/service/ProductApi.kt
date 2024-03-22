package com.thoughtworks.kotlin_assignment.service

import com.thoughtworks.kotlin_assignment.Entity.DataProduct
import com.thoughtworks.kotlin_assignment.Entity.Product
import retrofit2.Response
import retrofit2.http.GET


interface ProductApi {
    @GET("products/")
    suspend fun getAllProducts(): Response<List<DataProduct>>
}
