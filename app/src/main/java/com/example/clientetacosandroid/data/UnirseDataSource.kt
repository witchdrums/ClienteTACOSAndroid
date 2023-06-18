package com.example.clientetacosandroid.data

import android.security.keystore.UserNotAuthenticatedException
import com.example.clientetacosandroid.api.APIConsultante
import com.example.clientetacosandroid.api.respuestas.RespuestaMiembro
import com.example.clientetacosandroid.data.model.Miembro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class UnirseDataSource {

    suspend fun unirse(miembro: Miembro): Result<RespuestaMiembro>{
        try {
            return withContext(Dispatchers.IO) {
                val respuesta =
                    UnirseDataSource
                        .getRetrofit()
                        .create(APIConsultante::class.java)
                        .postRegistrarMiembro(miembro);
                val miembroRegistrado: RespuestaMiembro? = respuesta.body();
                if (miembroRegistrado != null) {
                    Result.Success(miembroRegistrado)
                } else {
                    Result.Error(UserNotAuthenticatedException("Error del servidor.", null));
                }
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error al registrar el usuario.", e))
        }
    };

    companion object {
        public fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://192.168.1.69:5174")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}