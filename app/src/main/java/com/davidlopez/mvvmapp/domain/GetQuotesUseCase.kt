package com.davidlopez.mvvmapp.domain

import com.davidlopez.mvvmapp.data.model.QuoteModel
import com.davidlopez.mvvmapp.data.repository.QuoteRepository


class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}