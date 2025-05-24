package com.davidlopez.mvvmapp.domain

import com.davidlopez.mvvmapp.data.model.QuoteModel
import com.davidlopez.mvvmapp.data.model.QuoteProvider


class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}