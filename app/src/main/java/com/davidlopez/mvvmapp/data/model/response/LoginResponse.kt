package com.davidlopez.mvvmapp.data.model.response

import com.davidlopez.mvvmapp.data.model.UserModel
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message:String?,
    @SerializedName("data")
    val data: UserModel?,
    @SerializedName("status")
    val status:String
)