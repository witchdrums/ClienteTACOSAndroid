package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.api.respuestas.Credenciales
import com.example.clientetacosandroid.api.respuestas.RespuestaMiembro
import com.example.clientetacosandroid.data.model.Miembro
import retrofit2.HttpException

class UnirseRepository (val dataSource: UnirseDataSource) {
    suspend fun unirse(miembro: Miembro): Result<RespuestaMiembro> {

        val result: Result<RespuestaMiembro> = dataSource.unirse(miembro)
        return result;

    }
}