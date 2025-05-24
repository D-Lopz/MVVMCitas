package com.davidlopez.mvvmapp.domain

import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.data.model.response.LoginResponse
import com.davidlopez.mvvmapp.data.repository.AuthRepository

class PostLoginUseCase {

    private val authRepository = AuthRepository()


    suspend operator fun invoke(loginRequest:LoginRequest):LoginResponse{
        return authRepository.login(loginRequest)
    }
}