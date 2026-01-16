package com.example.android_ecommerce_fakestore.network

import com.example.android_ecommerce_fakestore.data.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}
