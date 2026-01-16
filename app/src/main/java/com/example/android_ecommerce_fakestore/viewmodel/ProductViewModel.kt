package com.example.android_ecommerce_fakestore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_ecommerce_fakestore.data.model.Product
import com.example.android_ecommerce_fakestore.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts()
                _products.value = result
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
