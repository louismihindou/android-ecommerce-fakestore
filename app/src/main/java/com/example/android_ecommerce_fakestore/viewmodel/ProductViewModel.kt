//V1.0 - PIER - Init
//V1.1 - PIER - Recuperation categories

package com.example.android_ecommerce_fakestore.viewmodel

import android.util.Log
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

    //v1.1++<<
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> = _categories
    private val _filteredProducts = MutableStateFlow<List<Product>>(emptyList())
    val filteredProducts: StateFlow<List<Product>> = _filteredProducts
    //v1.1++>>

    fun fetchProducts(){
        viewModelScope.launch {
            try {//test - a ne pas conserver
                _products.value = repository.getProducts()
                //test - a ne pas conserver<<
                Log.d("ProductViewModel", "Produits chargés : ${_products.value}")
                // Affiche la liste des produits dans les logs
                fetchCategories() //appelle des categories - voir si a conserver.
                fetchGetProductsByCategory("men's clothing")
            } catch (e: Exception) {
            Log.e("ProductViewModel", "Erreur lors du chargement des produits : ${e.message}")
            // Affiche une erreur si le chargement échoue
        }
            //test - a ne pas conserver >>
        }

    }

    //v1.1++<<
    fun fetchCategories(){
        try { // test - a ne pas garder
            viewModelScope.launch{_categories.value = repository.getCategories()}
            //test - a ne pas conserver <<
            Log.d("ProductViewModel", "Catégories chargées : ${_categories.value}")
            // Affiche la liste des catégories dans les logs
        } catch (e: Exception) {
            Log.e("ProductViewModel", "Erreur lors du chargement des catégories : ${e.message}")        // Affiche une erreur si le chargement échoue
        } //test - a ne pas conserver >>
    }
    fun fetchGetProductsByCategory(category: String){
        try { //test - a ne pas conserver
            viewModelScope.launch {_filteredProducts.value = repository.getProductsByCategory(category)}
            //test - a ne pas conserver <<
            Log.d("ProductViewModel", "Produits filtrés (catégorie $category) : ${_filteredProducts.value}")
            // Affiche la liste des produits filtrés dans les logs
        } catch (e: Exception) {
            Log.e("ProductViewModel", "Erreur lors du chargement des produits de la catégorie $category : ${e.message}")
            // Affiche une erreur si le chargement échoue
        }
            //test - a ne pas conserver >>
    }
    //v1.1++>>

}