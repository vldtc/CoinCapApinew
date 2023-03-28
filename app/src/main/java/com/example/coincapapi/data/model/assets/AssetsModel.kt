package com.example.coincapapi.data.model.assets


import com.google.gson.annotations.SerializedName

data class AssetsModel(
    @SerializedName("data")
    val `data`: List<AssetsDataModel?>? = listOf(),
    @SerializedName("timestamp")
    val timestamp: Long? = 0
)