package com.example.android_ecommerce_fakestore.data.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.android_ecommerce_fakestore.viewmodel.ProductViewModel
import androidx.compose.ui.text.font.FontWeight


@Composable
fun ProductDetailScreen(productId: Int, viewModel: ProductViewModel) {

    val products by viewModel.products.collectAsState()
    val product = products.firstOrNull { it.id == productId }

    if (product == null) {
        Text("Produit introuvable")
        return
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        AsyncImage(
            model = product.image,
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = product.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${product.price} €",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Catégorie : ${product.category}",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
