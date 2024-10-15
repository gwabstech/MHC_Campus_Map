package com.gwabs.campus_map

// Helper function to validate email format
fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

// Helper function to validate password length (e.g., must be at least 6 characters)
fun isValidPassword(password: String): Boolean {
    return password.length >= 6
}

// Helper function to validate other form fields (e.g., cannot be empty)
fun isFieldNotEmpty(value: String): Boolean {
    return value.isNotEmpty()
}
