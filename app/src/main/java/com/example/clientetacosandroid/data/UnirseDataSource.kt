package com.example.clientetacosandroid.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UnirseDataSource {

    //suspend fun unirse(): Result<Object>{};

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