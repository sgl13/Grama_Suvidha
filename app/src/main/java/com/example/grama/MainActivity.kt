package com.example.grama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.grama.ui.theme.GRAMATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GRAMATheme {
                var currentScreen by remember { mutableStateOf("login") }

                if (currentScreen == "login") {
                    LoginScreen(
                        onLoginSuccess = {
                            // TODO: Handle navigation after successful login
                        },
                        onRegisterClick = {
                            currentScreen = "register"
                        }
                    )
                } else {
                    RegisterScreen(
                        onRegisterSuccess = {
                            // After successful registration, go back to login
                            currentScreen = "login"
                        },
                        onBackClick = {
                            currentScreen = "login"
                        }
                    )
                }
            }
        }
    }
}
