package com.example.disseny_responsive_i_adaptative.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.disseny_responsive_i_adaptative.viewmodel.MainViewModel

/**
 * Pantalla EXPANDED per tablets grans i mode landscape (> 840dp)
 * Layout de 2 columnes: informació del gimnàs + formulari
 */
@Composable
fun ExpandedScreen(navController: NavController, viewModel: MainViewModel) {
    val fullName by viewModel.fullName.observeAsState("")
    val birthDate by viewModel.birthDate.observeAsState("")
    val email by viewModel.email.observeAsState("")
    val phone by viewModel.phone.observeAsState("")
    val username by viewModel.username.observeAsState("")
    val password by viewModel.password.observeAsState("")
    val confirmPassword by viewModel.confirmPassword.observeAsState("")
    val termsAccepted by viewModel.termsAccepted.observeAsState(false)

    val fullNameError by viewModel.fullNameError.observeAsState()
    val birthDateError by viewModel.birthDateError.observeAsState()
    val emailError by viewModel.emailError.observeAsState()
    val phoneError by viewModel.phoneError.observeAsState()
    val usernameError by viewModel.usernameError.observeAsState()
    val passwordError by viewModel.passwordError.observeAsState()
    val confirmPasswordError by viewModel.confirmPasswordError.observeAsState()

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }
}