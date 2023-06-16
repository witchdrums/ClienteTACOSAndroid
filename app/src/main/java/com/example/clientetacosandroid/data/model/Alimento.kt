package com.example.clientetacosandroid.data.model

import java.util.Objects

data class Alimento(
    var id: Int=0,
    var nombre: String="",
    var descripcion: String="",
    var existencia: Int=0,
    var idImagen: Int=0,
    var imagen: Imagen? = null,
    var precio: Double=0.0,
    var idCategoria: Int=0
)
{

}