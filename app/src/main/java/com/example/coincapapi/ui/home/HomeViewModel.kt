package com.example.coincapapi.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.remote.ApiDetails
import com.example.coincapapi.data.remote.ApiRequest
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to Stock Previewer!"
    }
    val text: LiveData<String> = _text

    val home = MutableLiveData<AssetsModel>()

    fun getAssetsBitcoin() {
        val result = ApiDetails.getInstance(ApiDetails.BASE_URL).create(ApiRequest::class.java)

        GlobalScope.launch {
            val result = result.getAssetsBitcoin()
            _text.postValue(result.data?.joinToString("\n"))
            home.postValue(result) // runs when we have the resources
        }

    }
}