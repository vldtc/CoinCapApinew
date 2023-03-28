package com.example.coincapapi.data.model.markets


import com.google.gson.annotations.SerializedName

data class MarketsModel(
    @SerializedName("data")
    val `data`: List<MarketsDataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)