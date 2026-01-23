//V1.0 - PIER - Init
package com.example.android_ecommerce_fakestore.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartItemEntity(
    @PrimaryKey val productId: Int,
    val title: String,
    val price: Float,
    val description: String,
    val category: String,
    val image: String,
    val quantity: Int
)
