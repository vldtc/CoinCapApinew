package com.example.coincapapi.data.model.exchanges


import com.google.gson.annotations.SerializedName

data class ExchangesModel(
    @SerializedName("data")
    val `data`: List<ExchangesDataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)