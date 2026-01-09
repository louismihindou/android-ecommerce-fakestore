//V1.0 - PIER - Init

package com.example.android_ecommerce_fakestore.data.repository

import com.example.android_ecommerce_fakestore.data.model.Product
import com.example.android_ecommerce_fakestore.network.FakeStoreApiService
import com.example.android_ecommerce_fakestore.network.RetrofitClient

//class ProductRepository(private val apiService: FakeStoreApiService) {
class ProductRepository() {
    suspend fun getProducts(): List<Product> {
        return RetrofitClient.apiService.getProducts()
    }
}

