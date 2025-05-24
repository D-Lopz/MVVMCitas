package com.davidlopez.mvvmapp.data.network

import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiClient {
    @POST("sign_in")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
}