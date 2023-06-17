package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.api.respuestas.Credenciales
import com.example.clientetacosandroid.data.model.Miembro

class UnirseRepository (val dataSource: UnirseDataSource) {
    suspend fun unirse(miembro: Miembro): Result<Miembro> {
        /*
        val result = dataSource.unirse(username, password)

        if (result is Result.Success) {
            establecerCredenciales(result.data)
        }
        */
        return Result.Success(Miembro())
    }
}