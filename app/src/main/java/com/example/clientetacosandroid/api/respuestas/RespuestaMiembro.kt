package com.example.clientetacosandroid.api.respuestas

import com.example.clientetacosandroid.data.model.Miembro
import com.google.gson.annotations.SerializedName
import java.util.Objects

data class RespuestaMiembro(
    @SerializedName("datos")
    val miembro: Miembro,
    @SerializedName("codigo")
    val codigo: Integer,
    @SerializedName("mensaje")
    val mensaje: String,
)