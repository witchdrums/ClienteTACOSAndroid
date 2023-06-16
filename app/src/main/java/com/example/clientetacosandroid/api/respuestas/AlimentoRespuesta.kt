package com.example.clientetacosandroid.api.respuestas

import com.example.clientetacosandroid.data.model.Alimento;
import com.google.gson.annotations.SerializedName;

data class AlimentosRespuesta (@SerializedName("mensaje") val mensaje: String,
                               @SerializedName("codigo") val codigo: Integer,
                               @SerializedName("datos") var datos:List<Alimento>)
