//V1.0 - PIER - Init

package com.example.android_ecommerce_fakestore.data.model

import android.media.Rating

data class Product (
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Rating
)

data class Rating(
    val rate: Double,
    val count: Int
)
