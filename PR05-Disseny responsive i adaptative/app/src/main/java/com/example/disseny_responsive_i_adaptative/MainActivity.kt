package com.example.disseny_responsive_i_adaptative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.disseny_responsive_i_adaptative.ui.theme.Disseny_Responsive_i_AdaptativeTheme
import com.example.disseny_responsive_i_adaptative.ui.theme.navigation.Routes
import com.example.disseny_responsive_i_adaptative.ui.theme.view.CompactScreen
import com.example.disseny_responsive_i_adaptative.ui.theme.view.ConfirmationScreen
import com.example.disseny_responsive_i_adaptative.ui.theme.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Disseny_Responsive_i_AdaptativeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val viewModel: MainViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Routes.Register.route
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
                            val arguments = backStackEntry.arguments
                            val username: String
                            if (arguments != null) {
                                val tempUsername = arguments.getString("username")
                                if (tempUsername != null) {
                                    username = tempUsername
                                } else {
                                    username = ""
                                }
                            } else {
                                username = ""
                            }

                            ConfirmationScreen()
                        }
                    }
                }
            }
        }
    }
}