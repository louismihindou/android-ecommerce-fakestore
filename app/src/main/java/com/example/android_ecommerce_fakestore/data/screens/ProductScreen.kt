package com.example.android_ecommerce_fakestore.data.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.android_ecommerce_fakestore.viewmodel.ProductViewModel

@Composable
fun ProductScreen(viewModel: ProductViewModel, modifier: Modifier = Modifier) {
    val products = viewModel.products.collectAsState()

    Text(
        text = "Produits chargés : ${products.value.size}",
        modifier = modifier
    )
}
