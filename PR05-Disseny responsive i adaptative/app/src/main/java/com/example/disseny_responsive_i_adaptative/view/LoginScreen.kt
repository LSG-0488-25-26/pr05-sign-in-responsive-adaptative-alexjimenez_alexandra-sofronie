package com.example.disseny_responsive_i_adaptative.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.disseny_responsive_i_adaptative.viewmodel.MainViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: MainViewModel) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        val isCompact = maxWidth < 600.dp
        val isMedium = maxWidth >= 600.dp && maxWidth < 840.dp

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    if (isCompact) 16.dp else if (isMedium) 32.dp else 48.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Banner/Header
            Card(
                modifier = Modifier.fillMaxWidth(
                    when {
                        isCompact -> 1f
                        isMedium -> 0.9f
                        else -> 0.7f
                    }
                ),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE)),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            if (isCompact) 16.dp else 24.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🏋 FitLife Gym",
                        fontSize = if (isCompact) 28.sp else 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "El teu wellness comença aquí",
                        fontSize = if (isCompact) 16.sp else 20.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Card del formulario de Login
            Card(
                modifier = Modifier.fillMaxWidth(
                    when {
                        isCompact -> 1f
                        isMedium -> 0.8f
                        else -> 0.6f
                    }
                ),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            if (isCompact) 24.dp else 32.dp
                        )
                ) {
                    Text(
                        text = "Iniciar Sessió",
                        fontSize = if (isCompact) 24.sp else 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6200EE),
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                    val loginUsername by viewModel.username.observeAsState("")
                    val loginPassword by viewModel.password.observeAsState("")
                    val loginError by viewModel.passwordError.observeAsState("")

                    var passwordVisible by remember { mutableStateOf(false) }

                    OutlinedTextField(
                        value = loginUsername,
                        onValueChange = { viewModel.onUsernameChange(it) },
                        label = { Text("Nom d'usuari o Email") },
                        isError = loginError.isNotEmpty(),
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                }
            }
        }
    }
}