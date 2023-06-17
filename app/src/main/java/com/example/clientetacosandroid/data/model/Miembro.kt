package com.example.clientetacosandroid.data.model

data class Miembro(
    var id: Int = 0,
    var contrasena: String = "ASDFasdf1234",
    var pedidosPagados: Int = 0,
    var idPersona: Int = 0,
    var codigoConfirmacion: Int = 0,
    var persona: Persona = Persona(),
)
