package com.davidlopez.mvvmapp.data.network

import com.davidlopez.mvvmapp.core.RetrofitHelper
import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.data.model.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthApiService {
    private val retrofitAuth = RetrofitHelper.getRetrofitAuth()

    suspend fun login(loginRequest: LoginRequest):LoginResponse{
        return withContext(Dispatchers.IO){
            val response = retrofitAuth.create(AuthApiClient::class.java).login(loginRequest)
            response.body() ?: LoginResponse("Problemas con el servidor",null,"error")
        }
    }
}