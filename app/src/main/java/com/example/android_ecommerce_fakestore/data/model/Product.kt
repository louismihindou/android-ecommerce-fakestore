//V1.0 - PIER - Init
//v1.1 - PIER - Rectification champs produit

package com.example.android_ecommerce_fakestore.data.model

import android.media.Rating

data class Product (
    val id: Int,
    val title: String,
    //val price: Double, //v1.1--
    val price: Float, //v1.1++
    val description: String,
    val category: String,
    val image : String
    //val rating: Rating //v1.1--
)

//v1.1--<<
//data class Rating(
//    val rate: Double,
//    val count: Int
//)
//v1.1-->>
