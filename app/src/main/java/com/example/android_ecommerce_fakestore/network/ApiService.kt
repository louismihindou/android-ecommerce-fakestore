//V1.0 - PIER - Init
//V1.1 - PIER - Méthodes pour récupérer les catégories de produits et les produits par catégorie via l'API
//v1.2 - PIER - Rectification categories recupération depuis liste des produits.
package com.example.android_ecommerce_fakestore.network
//import com.example.android_ecommerce_fakestore.data.model.Product
import retrofit2.http.GET
//import retrofit2.http.Path

interface FakeStoreApiService {
    @GET("products")
    suspend fun getProducts(): List<com.example.android_ecommerce_fakestore.data.model.Product>
    //V1.2--<<
    // V1.1++<<
    //@GET("products/categories")
    //suspend fun getCategories(): List<String> // recup categories
    //@GET("products/category/{category}")
    //suspend fun getProductsByCategory(@Path("category") category: String): List<Product> //recup produits par categorie
    //V1.1++>>
    //V1.2-->>
}