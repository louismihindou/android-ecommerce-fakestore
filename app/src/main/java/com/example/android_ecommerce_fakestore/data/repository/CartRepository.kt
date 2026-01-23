//V1.0 - PIER - Init
package com.example.android_ecommerce_fakestore.data.repository

import androidx.compose.runtime.mutableStateOf
import com.example.android_ecommerce_fakestore.data.model.CartItem
import com.example.android_ecommerce_fakestore.data.model.CartItemEntity
import com.example.android_ecommerce_fakestore.data.model.Product
import java.math.BigDecimal



class CartRepository {
    private val _cartItems = mutableListOf<CartItemEntity>()

    fun addToCart(product: Product){

    }

    fun removeFromCart(product: Product){

    }

    fun getCartItem(): List<CartItemEntity> = _cartItems.toList()

    //fun getTotalPrice(): Double = _cartItems.sumOf { (it.product.price * it.quantity).toDouble() } //Non fonctionnel

    fun saveCartLocally() {}
    fun loadCartLocally() {}


}