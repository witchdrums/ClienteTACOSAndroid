package com.example.clientetacosandroid.api.peticiones

data class PeticionCredenciales (
    var email: String = "email",
    var contrasena: String = "contrasena",
    var esStaff: Boolean = false,
)
