package com.example.disseny_responsive_i_adaptative.ui.theme.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.disseny_responsive_i_adaptative.ui.theme.viewmodel.MainViewModel

@Composable
fun MediumScreen(navController: NavController, viewModel: MainViewModel) {
    // Observar los LiveData del ViewModel
    val fullName by viewModel.fullName.observeAsState("")
    val birthDate by viewModel.birthDate.observeAsState("")
    val email by viewModel.email.observeAsState("")
    val phone by viewModel.phone.observeAsState("")
    val username by viewModel.username.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val confirmPassword by viewModel.confirmPassword.observeAsState("")
    val termsAccepted by viewModel.termsAccepted.observeAsState(false)

    // Observar errores de validación
    val fullNameError by viewModel.fullNameError.observeAsState()
    val birthDateError by viewModel.birthDateError.observeAsState()
    val emailError by viewModel.emailError.observeAsState()
    val phoneError by viewModel.phoneError.observeAsState()
    val usernameError by viewModel.usernameError.observeAsState()
    val passwordError by viewModel.passwordError.observeAsState()
    val confirmPasswordError by viewModel.confirmPasswordError.observeAsState()

    // Estados locales para UI
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState())
    ) {
        // Banner més gran
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE)),
            shape = MaterialTheme.shapes.medium
        ){

        }
}
}