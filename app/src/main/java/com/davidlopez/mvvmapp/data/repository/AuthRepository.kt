package com.davidlopez.mvvmapp.data.repository

import com.davidlopez.mvvmapp.data.model.UserProvider
import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.data.model.response.LoginResponse
import com.davidlopez.mvvmapp.data.network.AuthApiService


class AuthRepository {

    private val  authApiService = AuthApiService()

    suspend fun login(loginRequest: LoginRequest): LoginResponse{

        val response = authApiService.login(loginRequest)

        if(response.status == "success"){
            UserProvider.user = response.data
        }
        return response
    }
}