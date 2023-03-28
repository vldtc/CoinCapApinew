package com.example.coincapapi.data.model.rates


import com.google.gson.annotations.SerializedName

data class RatesModel(
    @SerializedName("data")
    val `data`: List<RatesDataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)