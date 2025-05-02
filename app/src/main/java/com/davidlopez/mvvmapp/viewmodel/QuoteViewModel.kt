package com.davidlopez.mvvmapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidlopez.mvvmapp.model.QuoteModel
import com.davidlopez.mvvmapp.model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val _quoteModel = MutableLiveData<QuoteModel>()
    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        _quoteModel.postValue(currentQuote)
    }
}