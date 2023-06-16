package com.example.clientetacosandroid.data.model

import java.util.Objects

data class Imagen (
    var id : Int = 0,
    var nombre: String = "nombre",
    var imagenBytes: String? = null,
    var alimentos: Objects? = null
        )