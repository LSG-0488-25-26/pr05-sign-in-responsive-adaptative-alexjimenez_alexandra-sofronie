package com.example.disseny_responsive_i_adaptative.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        // Banner amplio
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF6200EE)),
            shape = MaterialTheme.shapes.medium
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        "🏋️ FitLife Gym",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "El teu wellness comença aquí",
                        fontSize = 20.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        "✓ Classes dirigides",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Text(
                        "✓ Sala de musculació",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                    Text(
                        "✓ Piscina climatitzada",
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = 0.9f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Layout 2 columnes
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 48.dp)
                .verticalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            // Columna esquerra - Info
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Uneix-te a FitLife",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF6200EE)
                )
                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text(
                            "Beneficis de ser soci:",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        BenefitItem("🎯", "Accés il·limitat 24/7")
                        BenefitItem("👥", "Classes dirigides gratuïtes")
                        BenefitItem("🏊", "Piscina i spa")
                        BenefitItem("🧘", "Zona de ioga i pilates")
                        BenefitItem("🤸", "Entrenador personal")
                        BenefitItem("🍎", "Assessorament nutricional")
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        Text("💪 Oferta especial", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
                        Text("Primer mes gratuït!", fontSize = 14.sp, color = Color(0xFF2E7D32), modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}

/*Funcio para los icons y texto de la columna esquerra,
es decir, sirve para mostrar cada item de beneficio
con su icono dentro de la card
 */
@Composable
fun BenefitItem(icon: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 24.sp, modifier = Modifier.padding(end = 12.dp))
        Text(text, fontSize = 16.sp)
    }
}