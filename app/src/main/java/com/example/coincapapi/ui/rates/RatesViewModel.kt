package com.example.coincapapi.ui.rates

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.data.model.rates.RatesModel
import com.example.coincapapi.data.remote.ApiDetails
import com.example.coincapapi.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RatesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text

    val rates = MutableLiveData<RatesModel>()

    fun getRates() {
        val result = ApiDetails.getInstance(ApiDetails.BASE_URL).create(ApiRequest::class.java)

        GlobalScope.launch {
            val result = result.getRates()
            _text.postValue(result.data?.joinToString("\n"))
            rates.postValue(result) // runs when we have the resources
        }

    }
}