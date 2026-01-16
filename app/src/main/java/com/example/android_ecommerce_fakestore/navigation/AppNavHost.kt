package com.example.android_ecommerce_fakestore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android_ecommerce_fakestore.data.screens.ProductDetailScreen
import com.example.android_ecommerce_fakestore.data.screens.ProductScreen
import com.example.android_ecommerce_fakestore.viewmodel.ProductViewModel

@Composable
fun AppNavHost(viewModel: ProductViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "catalogue"
    ) {
        composable("catalogue") {
            ProductScreen(
                viewModel = viewModel,
                onProductClick = { id ->
                    navController.navigate("detail/$id")
                }
            )
        }

        composable(
            route = "detail/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productId")!!
            ProductDetailScreen(
                productId = id,
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

    }
}
