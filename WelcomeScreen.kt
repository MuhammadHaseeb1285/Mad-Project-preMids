package com.example.dripdrop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFC6F6FD), Color(0xfff8bbd0))
                )
            )
    ) {
        // Logo Image
        Image(
            painter = painterResource(id = R.drawable.dripdroplogo),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 100.dp)
                .size(200.dp)
        )

        // Welcome Button
        Button(
            onClick = { navController.navigate("login") }, // Navigate to login screen
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCC00CC)),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "Welcome",
                fontSize = 35.sp,
                textAlign = TextAlign.Center,
            )
        }

        // Background Image
        Image(
            painter = painterResource(id = R.drawable.landing),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .aspectRatio(2.05f)
        )
    }
}
