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
import com.example.disseny_responsive_i_adaptative.ui.theme.Disseny_Responsive_i_AdaptativeTheme
import com.example.disseny_responsive_i_adaptative.ui.theme.view.CompactScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Disseny_Responsive_i_AdaptativeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CompactScreen()
                }
            }
        }
    }
}