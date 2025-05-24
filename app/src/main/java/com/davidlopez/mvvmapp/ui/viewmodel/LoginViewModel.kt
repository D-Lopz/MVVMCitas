package com.davidlopez.mvvmapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidlopez.mvvmapp.data.model.request.LoginRequest
import com.davidlopez.mvvmapp.data.model.response.LoginResponse
import com.davidlopez.mvvmapp.domain.PostLoginUseCase
import com.davidlopez.mvvmapp.data.model.UserModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel () {
    val _loginResponse = MutableLiveData<LoginResponse>()
    val _userModel = MutableLiveData<UserModel?>()

    //FeedBack
    val _isLoading = MutableLiveData<Boolean>()
    val _message = MutableLiveData<String?>()

    //Llamdado al caso de uso
    val loginUseCase = PostLoginUseCase()

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch{
            _isLoading.postValue(true)

            val result = loginUseCase(loginRequest)
            _loginResponse.postValue(result)

            when (result.status){
                "success" ->{
                    _userModel.postValue(result.data)
                    _isLoading.postValue(false)
                }
                "invalid" ->{
                    _message.postValue(result.message)
                    _isLoading.postValue(false)
                }
                "error" ->{
                    _message.postValue("Usuario no registrado! \uD83D\uDE14")
                    _isLoading.postValue(false)
                }
            }
        }
    }
}