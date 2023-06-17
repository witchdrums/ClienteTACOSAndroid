package com.example.clientetacosandroid.data

import android.security.keystore.UserNotAuthenticatedException
import com.example.clientetacosandroid.api.APIConsultante
import com.example.clientetacosandroid.data.model.LoggedInUser
import com.example.clientetacosandroid.api.peticiones.PeticionCredenciales
import com.example.clientetacosandroid.api.respuestas.Credenciales
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    suspend fun login(email: String, contrasena: String): Result<Credenciales> {
        try {
            return withContext(Dispatchers.IO) {
                // TODO: handle loggedInUser authentication
                val respuesta =
                    LoginDataSource
                        .getRetrofit()
                        .create(APIConsultante::class.java)
                        .postIniciarSesion(
                            PeticionCredenciales(email = email, contrasena = contrasena)
                        );
                val credenciales: Credenciales? = respuesta.body();
                if (credenciales != null) {
                    Result.Success(credenciales)
                } else {
                    Result.Error(UserNotAuthenticatedException("Error del servidor.", null));
                }
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

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