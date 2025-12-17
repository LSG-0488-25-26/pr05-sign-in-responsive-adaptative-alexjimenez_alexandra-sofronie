package com.example.disseny_responsive_i_adaptative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.disseny_responsive_i_adaptative.ui.theme.Disseny_Responsive_i_AdaptativeTheme
import com.example.disseny_responsive_i_adaptative.navigation.Routes
import com.example.disseny_responsive_i_adaptative.view.CompactScreen
import com.example.disseny_responsive_i_adaptative.view.ConfirmationScreen
import com.example.disseny_responsive_i_adaptative.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Disseny_Responsive_i_AdaptativeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val viewModel: MainViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.Register.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Routes.Register.route) {
                            CompactScreen(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable(
                            route = Routes.Confirmation.route,
                            arguments = listOf(
                                navArgument("username") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val args = backStackEntry.arguments!!   // Forzamos que los argumentos no sean nulos usando !!
                            val username = args.getString("username", "")
                            
                            ConfirmationScreen()
                        }
                    }
                }
            }
        }
    }
}