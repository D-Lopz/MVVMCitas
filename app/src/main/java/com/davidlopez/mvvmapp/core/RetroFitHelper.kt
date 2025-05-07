package com.davidlopez.mvvmapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app"
object RetroFitHelper {
    fun getRetroFit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}