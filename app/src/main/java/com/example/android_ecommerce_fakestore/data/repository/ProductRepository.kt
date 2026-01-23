//V1.0 - PIER - Init
//V1.1 - PIER - Methode à appeler pour recuperation des categories et des produits par categorie
//v1.2 - PIER - Rectification categories, recupération depuis liste des produits.
package com.example.android_ecommerce_fakestore.data.repository

import com.example.android_ecommerce_fakestore.data.model.Product
import com.example.android_ecommerce_fakestore.network.RetrofitClient
//import java.net.URLEncoder //v1.2--

class ProductRepository() {
    suspend fun getProducts(): List<Product> {
        return RetrofitClient.apiService.getProducts()
    }

    //V1.1++<<
    suspend fun getCategories(): List<String>{
        //v1.2++<<
        val products = getProducts()
        return products.map {it.category}.distinct()
        //v1.2++>>
        //return RetrofitClient.apiService.getCategories() //V1.2--
    }
    suspend fun getProductsByCategory(category: String): List<Product>{
        //v1.2++<<
        val products = getProducts()
        return products.filter{it.category==category}
        //v1.2++>>
        //V1.2--<<
    //    val encodedCategory = URLEncoder.encode(category,"UTF-8")
    //    return RetrofitClient.apiService.getProductsByCategory(encodedCategory)
        //V1.2-->>
    }
    //v1.1++>>
}

