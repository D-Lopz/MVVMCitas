package com.davidlopez.mvvmapp.data.repository

import com.davidlopez.mvvmapp.data.model.QuoteModel
import com.davidlopez.mvvmapp.data.model.QuoteProvider
import com.davidlopez.mvvmapp.data.network.QuoteService


class QuoteRepository {
    private val quoteServiceApi = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = quoteServiceApi.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}