package com.example.clientetacosandroid.api.respuestas

import com.example.clientetacosandroid.data.model.Alimento;
import com.google.gson.annotations.SerializedName;

data class AlimentosRespuesta (
    @SerializedName("datos")
    val datos:ArrayList<Alimento>,
    @SerializedName("codigo")
    val codigo: Integer,
    @SerializedName("mensaje")
    val mensaje: String
)
