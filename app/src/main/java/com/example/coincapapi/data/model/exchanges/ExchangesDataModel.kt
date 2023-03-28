package com.example.coincapapi.data.model.exchanges


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExchangesDataModel(
    @SerializedName("exchangeId")
    val exchangeId: String? = "",
    @SerializedName("exchangeUrl")
    val exchangeUrl: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("percentTotalVolume")
    val percentTotalVolume: String? = "",
    @SerializedName("rank")
    val rank: String? = "",
    @SerializedName("socket")
    val socket: Boolean? = false,
    @SerializedName("tradingPairs")
    val tradingPairs: String? = "",
    @SerializedName("updated")
    val updated: Long? = 0,
    @SerializedName("volumeUsd")
    val volumeUsd: String? = ""
) : Serializable