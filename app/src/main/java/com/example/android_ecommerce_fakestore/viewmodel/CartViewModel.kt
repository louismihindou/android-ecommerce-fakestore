//V1.0 - PIER - Init
package com.example.android_ecommerce_fakestore.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android_ecommerce_fakestore.data.model.CartItemEntity
import com.example.android_ecommerce_fakestore.data.model.Product
import com.example.android_ecommerce_fakestore.data.repository.CartRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel(private val cartRepository: CartRepository) : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItemEntity>>(emptyList())
    val cartItems: StateFlow<List<CartItemEntity>> = _cartItems

    private val _totalPrice = MutableStateFlow<Double>(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice

    fun addToCart(product: Product){
        cartRepository.addToCart(product)
        updateCartState()
    }
    fun removeFromCart(product: Product){
        cartRepository.removeFromCart(product)
        updateCartState()
    }

    private fun updateCartState(){
        _cartItems.value = cartRepository.getCartItem()
        //_totalPrice.value = cartRepository.getTotalPrice() Non fonctionnel
    }

    fun loadCart() {
        cartRepository.loadCartLocally()
        updateCartState()
    }
}