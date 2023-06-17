package com.example.clientetacosandroid.ui.unirse

/**
 * Data validation state of the login form.
 */
data class UnirseFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val nombreError: Int? = null,
    val direccionError: Int? = null,
    val telefonoError: Int? = null,
    val isDataValid: Boolean = false
)