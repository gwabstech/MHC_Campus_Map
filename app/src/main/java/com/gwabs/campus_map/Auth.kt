package com.gwabs.campus_map

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gwabs.campus_map.ui.theme.MHCCampusMapTheme
import com.google.firebase.auth.FirebaseAuth

class Auth : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MHCCampusMapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigator(innerPadding) {
                        // Navigate to main activity upon successful login
                        val intent = Intent(this, MapsActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }
    }

    // Check if the user is already logged in using onStart()
    override fun onStart() {
        super.onStart()

        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            // If the user is logged in, navigate to MapsActivity
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
            finish() // Close the Auth activity
        }
    }
}

@Composable
fun AppNavigator(
    innersPadding: PaddingValues,
    onLoginSuccess: () -> Unit = {}
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController = navController, onLoginSuccess = onLoginSuccess) }
        composable("signup") { SignUpScreen(navController = navController) }
    }
}
