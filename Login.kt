package com.example.dripdrop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var loginError by remember { mutableStateOf("") } // State for login error message

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color(0xFFC6F6FD), Color(0xfff8bbd0))
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo Image
            Image(
                painter = painterResource(id = R.drawable.dripdroplogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(223.dp)
                    .padding(top = 50.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Username TextField
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Enter Username or Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Password TextField
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Login Button
            Button(
                onClick = {
                    // Example login validation (replace with your actual login logic)
                    if (username.text == "user" && password.text == "password") {
                        // Handle successful login
                        navController.navigate("home") // Navigate to home or another screen
                    } else {
                        // Set error message for invalid credentials
                        loginError = "Invalid username or password"
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFCC00CC)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Log In",
                    color = Color.White,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Display error message if login fails
            if (loginError.isNotEmpty()) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = loginError,
                    color = Color.Red,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Sign Up Text
            Text(
                text = "Don't have an account? Sign Up",
                color = Color.Blue,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clickable {
                        // Navigate to the sign-up screen
                        navController.navigate("signup")
                    },
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Bottom Image
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "Additional Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop // Ensure the image covers the full width
            )
        }
    }
}
