package com.example.disseny_responsive_i_adaptative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
import com.example.disseny_responsive_i_adaptative.view.ExpandedScreen
import com.example.disseny_responsive_i_adaptative.view.LoginScreen
import com.example.disseny_responsive_i_adaptative.view.MediumScreen
import com.example.disseny_responsive_i_adaptative.viewmodel.MainViewModel
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.unit.dp

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
                        startDestination = Routes.Login.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Routes.Login.route) {
                            LoginScreen(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable(Routes.Register.route) {
                            BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                                val screenType = when {
                                    maxWidth < 600.dp -> "COMPACT"
                                    maxWidth >= 600.dp && maxWidth < 840.dp -> "MEDIUM"
                                    else -> "EXPANDED"
                                }

                                when (screenType) {
                                    "COMPACT" -> CompactScreen(navController, viewModel)
                                    "MEDIUM" -> MediumScreen(navController, viewModel)
                                    "EXPANDED" -> ExpandedScreen(navController, viewModel)
                                    else -> CompactScreen(navController, viewModel)
                                }
                            }
                        }
                        //Pantalla de confirmación con argumento username
                        composable(
                            route = Routes.Confirmation.route,
                            arguments = listOf(
                                navArgument("username") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            //Obtenemos el argumento username de la navegación
                            val args = backStackEntry.arguments!!   // Forzamos que los argumentos no sean nulos usando !!
                            val username = args.getString("username", "")
                            
                            //Llamamos a la pantalla de confirmación pasando los siguientes paramteros
                            ConfirmationScreen(
                                navController = navController,  //Permitimso la navegación
                                username = username             //Nombre del usuario registrado
                            )
                        }
                    }
                }
            }
        }
    }
}

//Preview para CompactScreen
@Preview(showBackground = true, name = "Compact Screen")
@Composable
fun CompactScreenPreview() {
    Disseny_Responsive_i_AdaptativeTheme {
        CompactScreen(
            navController = rememberNavController(),
            viewModel = viewModel()
        )
    }
}

//Preview para ConfirmationScreen
@Preview(showBackground = true, name = "Confirmation Screen")
@Composable
fun ConfirmationScreenPreview() {
    Disseny_Responsive_i_AdaptativeTheme {
        ConfirmationScreen(
            navController = rememberNavController(),
            username = "AlexJimenez"
        )
    }
}

//Preview para ExpandedScreen
@Preview(showBackground = true, name = "Expanded Screen")
@Composable
fun ExpandedScreenPreview() {
    Disseny_Responsive_i_AdaptativeTheme {
        ExpandedScreen(
            navController = rememberNavController(),
            viewModel = viewModel()
        )
    }
}

//Preview para MediumScreen
@Preview(showBackground = true, name = "Medium Screen")
@Composable
fun MediumScreenPreview() {
    Disseny_Responsive_i_AdaptativeTheme {
        MediumScreen(
            navController = rememberNavController(),
            viewModel = viewModel()
        )
    }
}