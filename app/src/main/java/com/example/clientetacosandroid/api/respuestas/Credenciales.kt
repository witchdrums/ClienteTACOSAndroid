package com.example.clientetacosandroid.api.respuestas

import com.example.clientetacosandroid.data.model.Miembro
import com.google.gson.annotations.SerializedName
import java.util.Objects

data class Credenciales(
    @SerializedName("miembro")
    val miembro: Miembro,
    @SerializedName("staff")
    val staff: Objects? = null,
    @SerializedName("codigo")
    val codigo: Integer,
    @SerializedName("mensaje")
    val mensaje: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("expira")
    val expira: Integer
)
