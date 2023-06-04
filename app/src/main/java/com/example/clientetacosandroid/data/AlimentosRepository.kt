package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.data.AlimentosDataSource
import com.example.clientetacosandroid.data.model.Alimento

class AlimentosRepository {
    companion object {
        val dataSource: AlimentosDataSource = AlimentosDataSource()
        var alimentos: MutableList<Alimento>? = null
            private set
        init {
            alimentos = null
        }
    }
    suspend fun cargarAlimentos(): Result<List<Alimento>> {
        if (alimentos != null)
            return Result.Success(alimentos!!)
        else
            return recargarAlimentos();
    }


    suspend fun recargarAlimentos() : Result<List<Alimento>> {
        val resultado = dataSource.cargarAlimentos()
        if (resultado is Result.Success)
            alimentos = resultado.data.toMutableList();
        return resultado;
    }
}