package com.gwabs.campus_map

// Jetpack Navigation

// Firebase Authentication and Database

// Android utilities

// For progress indicator
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.gwabs.campus_map.ui.theme.GreenKadunaPoly

@Composable
fun SignUpScreen(navController: NavController) {
    val context = LocalContext.current

    // Form input fields
    val name = remember { mutableStateOf("") }
    val department = remember { mutableStateOf("") }
    val idNumber = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    // Loading and error state
    val isLoading = remember { mutableStateOf(false) }
    val errorMessage = remember { mutableStateOf<String?>(null) }

    // Validation state
    val validationError = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Create Account",
            color = GreenKadunaPoly,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Name input
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Full Name") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Department input
        TextField(
            value = department.value,
            onValueChange = { department.value = it },
            label = { Text("Department") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ID Number input
        TextField(
            value = idNumber.value,
            onValueChange = { idNumber.value = it },
            label = { Text("ID Number") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email input
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Number input
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password input
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = GreenKadunaPoly,
                focusedLabelColor = GreenKadunaPoly
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Validation Error Message
        if (validationError.value != null) {
            Text(text = validationError.value ?: "", color = Color.Red)
        }

        // Loading Indicator
        if (isLoading.value) {
            CircularProgressIndicator(color = GreenKadunaPoly)
        }

        // Sign-Up Button
        Button(
            onClick = {
                // Validate the form before proceeding
                when {
                    !isFieldNotEmpty(name.value) -> validationError.value = "Full Name is required"
                    !isFieldNotEmpty(department.value) -> validationError.value = "Department is required"
                    !isFieldNotEmpty(idNumber.value) -> validationError.value = "ID Number is required"
                    !isValidEmail(email.value) -> validationError.value = "Invalid Email"
                    !isFieldNotEmpty(phoneNumber.value) -> validationError.value = "Phone Number is required"
                    !isValidPassword(password.value) -> validationError.value = "Password must be at least 6 characters long"
                    else -> {
                        validationError.value = null
                        isLoading.value = true
                        errorMessage.value = null

                        // Firebase Authentication to register user
                        FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(email.value, password.value)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    val userId = FirebaseAuth.getInstance().currentUser?.uid
                                    // Save additional data to Firebase Realtime Database
                                    val userRef = FirebaseDatabase.getInstance().getReference("users").child(userId!!)
                                    val user = mapOf(
                                        "name" to name.value,
                                        "department" to department.value,
                                        "idNumber" to idNumber.value,
                                        "email" to email.value,
                                        "phoneNumber" to phoneNumber.value
                                    )

                                    userRef.setValue(user).addOnCompleteListener { dbTask ->
                                        isLoading.value = false
                                        if (dbTask.isSuccessful) {
                                            Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                                            navController.navigate("login")
                                        } else {
                                            errorMessage.value = dbTask.exception?.message
                                        }
                                    }
                                } else {
                                    isLoading.value = false
                                    errorMessage.value = task.exception?.message
                                }
                            }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(GreenKadunaPoly)
        ) {
            Text("Sign Up", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Show error message if any
        if (errorMessage.value != null) {
            Text(text = "Error: ${errorMessage.value}", color = Color.Red)
        }

        // Navigate to login page
        TextButton(onClick = { navController.navigate("login") }) {
            Text("Already have an account? Log In", color = GreenKadunaPoly)
        }
    }
}
