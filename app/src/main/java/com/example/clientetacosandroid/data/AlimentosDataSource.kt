package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.data.model.Alimento
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.Date


class AlimentosDataSource {
    suspend fun cargarAlimentos(): Result<List<Alimento>> {
        try{
            return withContext(Dispatchers.IO){

                var alimentos: List<Alimento> = mutableListOf(
                    Alimento(1,"Pastor",30.0),
                    Alimento(2,"Bisteck",30.0),
                    Alimento(3,"Suadero",30.0),
                );
                if(true)
                    Result.Success(alimentos);
                else
                    Result.Error(IOException("Error al cargar los Alimentos", null))
            }
        }catch(e: Throwable){
            return Result.Error(IOException("Error al cargar los alimentos", e));
        }
    }
}