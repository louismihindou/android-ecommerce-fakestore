//V1.0 - PIER - Init
//V1.1 - PIER - Recuperation categories

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


    //v1.1++<<
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories.asStateFlow()

    private val _filteredProducts = MutableStateFlow<List<Product>>(emptyList())
    val filteredProducts: StateFlow<List<Product>> = _filteredProducts.asStateFlow()
    //v1.1++>>


    fun fetchProducts() {
        viewModelScope.launch {
            val result = repository.getProducts()
            _products.value = result
            _filteredProducts.value = result // par défaut : tout afficher
        }
    }

    //v1.1++<<
    fun fetchCategories() {
        viewModelScope.launch {
            _categories.value = repository.getCategories()
        }
    }

    fun filterByCategory(category: String?) {
        viewModelScope.launch {
            _filteredProducts.value = if (category == null) {
                _products.value
            } else {
                repository.getProductsByCategory(category)
            }
        }
    }
    //v1.1++>>
}
