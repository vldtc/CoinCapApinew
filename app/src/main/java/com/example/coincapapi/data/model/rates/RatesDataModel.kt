package com.example.coincapapi.data.model.rates


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RatesDataModel(
    @SerializedName("currencySymbol")
    val currencySymbol: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("rateUsd")
    val rateUsd: String? = "",
    @SerializedName("symbol")
    val symbol: String? = "",
    @SerializedName("type")
    val type: String? = ""
) : Serializable