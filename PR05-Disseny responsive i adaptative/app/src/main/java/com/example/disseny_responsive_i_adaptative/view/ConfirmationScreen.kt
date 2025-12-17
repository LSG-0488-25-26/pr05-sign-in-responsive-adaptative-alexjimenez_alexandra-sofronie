package com.example.disseny_responsive_i_adaptative.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.disseny_responsive_i_adaptative.navigation.Routes

/**
 * Pantalla de confirmació ADAPTATIVA
 * S'adapta a les 3 mides de pantalla utilitzant BoxWithConstraints
 */

@Composable
fun ConfirmationScreen(navController: NavController, username: String) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {
        val isCompact = maxWidth < 600.dp
        val isMedium = maxWidth >= 600.dp && maxWidth < 840.dp

        //Column principal
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(if (isCompact) 24.dp else 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            //Card de confirmación
            Card(
                modifier = Modifier
                    .fillMaxWidth(
                        when {
                            isCompact -> 1f
                            isMedium -> 0.8f
                            else -> 0.6f
                        }
                    )
                    .wrapContentHeight(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(if (isCompact) 32.dp else 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Icona de confirmació
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Success",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(if (isCompact) 80.dp else 120.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp)) //Espacio entre los elementos, en este caso de 24.dp

                    //Títol
                    Text(
                        text = "Registre Completat!",
                        fontSize = if (isCompact) 28.sp else 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF6200EE),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Missatge de benvinguda
                    Text(
                        text = "Benvingut/da a FitLife Gym,",
                        fontSize = if (isCompact) 18.sp else 22.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )

                    Text(
                        text = username.ifEmpty { "Usuari" }, //Si está vacio, mostrará "Usuari"
                        fontSize = if (isCompact) 24.sp else 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF6200EE),
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    //Divider (linia divisora)
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(0.8f),
                        color = Color.LightGray
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    //Informació addicional
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3E5F5))
                    ) {
                        Column(modifier = Modifier.padding(20.dp)) {
                            Text(
                                text = "Següents passos:",
                                fontSize = if (isCompact) 16.sp else 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF6200EE)
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            InfoItem("✉️", "Revisa el teu email")
                            InfoItem("📱", "Descarrega la app")
                            InfoItem("🗓️", "Reserva la teva classe")
                            InfoItem("🎉", "Gaudeix del primer mes!")
                        }
                    }
                }
            }
        }
    }
}

//Funció implementada para la Informació adicional dentro del Card
@Composable
fun InfoItem(icon: String, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon, fontSize = 18.sp, modifier = Modifier.padding(end = 12.dp))
        Text(text, fontSize = 14.sp, color = Color.DarkGray)
    }
}