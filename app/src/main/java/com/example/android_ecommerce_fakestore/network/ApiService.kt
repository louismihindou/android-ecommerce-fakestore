//V1.0 - PIER - Init

package com.example.android_ecommerce_fakestore.network
import retrofit2.http.GET

interface FakeStoreApiService {
    @GET("products")
    suspend fun getProducts(): List<com.example.android_ecommerce_fakestore.data.model.Product>
}