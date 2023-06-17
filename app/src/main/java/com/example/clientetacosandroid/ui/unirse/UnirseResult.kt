package com.example.clientetacosandroid.ui.unirse

/**
 * Authentication result : success (user details) or error message.
 */
data class UnirseResult(
    val success: Boolean = false,
    val error: Int? = null
)