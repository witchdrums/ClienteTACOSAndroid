package com.example.clientetacosandroid.api
import com.example.clientetacosandroid.api.peticiones.PeticionCredenciales
import com.example.clientetacosandroid.api.respuestas.Credenciales
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsultante {
    @POST("Login")
    suspend fun postIniciarSesion(@Body peticionCredenciales: PeticionCredenciales): Response<Credenciales>
}