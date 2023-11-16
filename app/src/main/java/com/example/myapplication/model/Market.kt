package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("limit")
    val limit: List<Limit>,
    @SerializedName("marketId")
    val marketId: String,
    @SerializedName("marketName")
    val marketName: String,
    @SerializedName("runners")
    val runners: List<Runner>,
    @SerializedName("status")
    val status: Boolean
)