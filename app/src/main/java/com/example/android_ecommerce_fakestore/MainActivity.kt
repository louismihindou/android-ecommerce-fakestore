package com.example.android_ecommerce_fakestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.android_ecommerce_fakestore.network.RetrofitClient
import com.example.android_ecommerce_fakestore.data.repository.ProductRepository
import com.example.android_ecommerce_fakestore.navigation.AppNavHost
import com.example.android_ecommerce_fakestore.ui.theme.AndroidecommercefakestoreTheme
import com.example.android_ecommerce_fakestore.viewmodel.ProductViewModel
import com.example.android_ecommerce_fakestore.viewmodel.ProductViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(ProductRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Charger les produits dès le lancement
        viewModel.fetchProducts()
        viewModel.fetchCategories()



        setContent {
            AndroidecommercefakestoreTheme {
                // Navigation principale de l'application
                AppNavHost(viewModel = viewModel)
            }
        }
    }
}
