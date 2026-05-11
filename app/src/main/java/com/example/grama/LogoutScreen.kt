package com.example.grama

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gramasuvidha.portal.ui.theme.*

@Composable
fun LogoutScreen(
    onConfirmLogout: () -> Unit,
    onCancel: () -> Unit
) {
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
                .fillMaxWidth(0.85f)
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = GreenPrimary
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = "Logout | ಲಾಗ್ ಔಟ್",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = GreenPrimary
                )
                
                Spacer(modifier = Modifier.height(12.dp))
                
                Text(
                    text = "Are you sure you want to logout?\nನೀವು ಲಾಗ್ ಔಟ್ ಮಾಡಲು ಖಚಿತವಾಗಿ ಬಯಸುವಿರಾ?",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    lineHeight = 20.sp
                )
                
                Spacer(modifier = Modifier.height(32.dp))
                
                Button(
                    onClick = onConfirmLogout,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Yes, Logout | ಹೌದು, ಲಾಗ್ ಔಟ್ ಮಾಡಿ", color = Color.White, fontWeight = FontWeight.Bold)
                }
                
                Spacer(modifier = Modifier.height(12.dp))
                
                OutlinedButton(
                    onClick = onCancel,
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = ButtonDefaults.outlinedButtonBorder(enabled = true)
                ) {
                    Text("Cancel | ರದ್ದುಮಾಡಿ", color = Color.Gray)
                }
            }
        }
    }
}
