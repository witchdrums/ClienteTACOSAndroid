package com.example.clientetacosandroid.api
import com.example.clientetacosandroid.api.respuestas.AlimentosRespuesta
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header

interface APIMenu {
    @GET("Menu/ObtenerAlimentosConImagenes")
    suspend fun getListaAlimentos(): Response<AlimentosRespuesta>
}