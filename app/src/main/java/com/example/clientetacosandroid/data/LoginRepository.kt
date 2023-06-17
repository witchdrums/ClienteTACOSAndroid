package com.example.clientetacosandroid.data

import com.example.clientetacosandroid.api.respuestas.Credenciales
import com.example.clientetacosandroid.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var credenciales: Credenciales? = null
        private set

    val isLoggedIn: Boolean
        get() = credenciales != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        credenciales = null
    }

    fun logout() {
        credenciales = null
        dataSource.logout()
    }

    suspend fun login(username: String, password: String): Result<Credenciales> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            establecerCredenciales(result.data)
        }

        return result
    }

    private fun establecerCredenciales(credenciales: Credenciales) {
        this.credenciales = credenciales

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}