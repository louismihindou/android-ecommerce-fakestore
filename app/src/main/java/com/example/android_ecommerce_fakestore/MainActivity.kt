package com.example.android_ecommerce_fakestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.android_ecommerce_fakestore.network.RetrofitClient
import com.example.android_ecommerce_fakestore.data.repository.ProductRepository
import com.example.android_ecommerce_fakestore.data.screens.ProductScreen
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

        viewModel.fetchProducts()

        setContent {
            AndroidecommercefakestoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProductScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
