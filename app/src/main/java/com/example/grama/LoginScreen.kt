package com.example.grama

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grama.ui.theme.GRAMATheme
import com.gramasuvidha.portal.ui.theme.*

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isUserSelected by remember { mutableStateOf(true) }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(GradientStart, GradientEnd)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 32.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo placeholder
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(GreenPrimary, RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Eco,
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Grama-Suvidha",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = GreenPrimary
                )
                Text(
                    text = "ಗ್ರಾಮ ಸುವಿಧಾ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = GreenPrimary
                )
                Text(
                    text = "Village Services Portal | ಗ್ರಾಮ ಸೇವಾ ಪೋರ್ಟಲ್",
                    fontSize = 12.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // User/Admin Toggle
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { isUserSelected = true },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isUserSelected) GreenSelected else Color.Transparent,
                            contentColor = if (isUserSelected) Color.White else Color.Gray
                        ),
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text("User | ಬಳಕೆದಾರ", fontSize = 12.sp)
                    }
                    Button(
                        onClick = { isUserSelected = false },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (!isUserSelected) GreenSelected else Color.Transparent,
                            contentColor = if (!isUserSelected) Color.White else Color.Gray
                        ),
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            Icons.Default.AdminPanelSettings,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text("Admin | ನಿರ್ವಾಹಕ", fontSize = 12.sp)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Email Field
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Gray
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            "Email Address | ಇಮೇಲ್ ವಿಳಾಸ *",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Enter your email", fontSize = 14.sp) },
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Password Field
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Lock,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Gray
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            "Password | ಪಾಸ್‌ವರ್ಡ್ *",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Enter your password", fontSize = 14.sp) },
                        shape = RoundedCornerShape(8.dp),
                        singleLine = true,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Login Button
                Button(
                    onClick = {
                        if (email.isNotBlank() && password.isNotBlank()) {
                            onLoginSuccess()
                        } else {
                            Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF43A047)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Login | ಲಾಗಿನ್ ಮಾಡಿ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(Modifier.width(8.dp))
                    Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "New to Grama-Suvidha? | ಹೊಸ ಬಳಕೆದಾರರೇ?",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Register Section
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(1.dp, Color(0xFF43A047), RoundedCornerShape(12.dp))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Are you a new person?\nನೀವು ಹೊಸ ವ್ಯಕ್ತಿ ಆಗಿದ್ದೀರಾ?",
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 18.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = onRegisterClick,
                            colors = ButtonDefaults.buttonColors(containerColor = OrangeSecondary),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.EditNote, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Register Now | ನೊಂದಾಯಿಸಿ")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "ಗ್ರಾಮ ಸುವಿಧಾ © 2024 | Grama-Suvidha Portal",
                    fontSize = 10.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    GRAMATheme {
        LoginScreen()
    }
}
