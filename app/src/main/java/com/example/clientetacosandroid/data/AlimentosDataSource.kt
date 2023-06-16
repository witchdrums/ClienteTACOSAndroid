package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.api.APIMenu
import com.example.clientetacosandroid.data.model.Alimento
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import java.io.IOException
import java.util.Date


class AlimentosDataSource {
    suspend fun cargarAlimentos(): Result<List<Alimento>> {
        try{
            return withContext(Dispatchers.IO){
                val peticion =
                    AlimentosDataSource
                        .getRetrofit()
                        .create(APIMenu::class.java)
                        .getListaAlimentos();
                val respuesta = peticion.body();
                /*
                var alimentos: List<Alimento> = mutableListOf(
                    Alimento(1,"Pastor",30.0),
                    Alimento(2,"Bisteck",30.0),
                    Alimento(3,"Suadero",30.0),
                );
                */

                if(respuesta != null)
                    Result.Success(respuesta.datos);
                else
                    Result.Error(IOException("Error al cargar los Alimentos", null))
            }
        }catch(e: Throwable){
            return Result.Error(IOException("Error al cargar los alimentos", e));
        }
    }

    companion object {
        public fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://192.168.56.1:7118")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}