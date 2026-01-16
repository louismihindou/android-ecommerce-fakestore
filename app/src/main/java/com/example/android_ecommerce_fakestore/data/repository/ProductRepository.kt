package com.example.android_ecommerce_fakestore.data.repository

import com.example.android_ecommerce_fakestore.network.ApiService

class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts() = apiService.getProducts()
}
