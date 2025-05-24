package com.davidlopez.mvvmapp.data.network

import com.davidlopez.mvvmapp.core.RetrofitHelper
import com.davidlopez.mvvmapp.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.jvm.java

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{

        return withContext(Dispatchers.IO){
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}