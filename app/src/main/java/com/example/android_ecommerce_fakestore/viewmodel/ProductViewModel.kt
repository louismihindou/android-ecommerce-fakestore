//V1.0 - PIER - Init
package com.example.android_ecommerce_fakestore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_ecommerce_fakestore.data.model.Product
import com.example.android_ecommerce_fakestore.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun fetchProducts(){
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }
}