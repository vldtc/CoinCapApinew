package com.example.coincapapi.data.remote

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {

    const val BASE_URL = "https://api.coincap.io"
    const val ASSETS = "/v2/assets"
    const val ASSETS_BTC = "v2/assets/bitcoin"
    const val RATES = "/v2/rates"
    const val EXCHANGES = "/v2/exchanges"
    const val MARKET = "/v2/markets"

    fun getInstance(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
}