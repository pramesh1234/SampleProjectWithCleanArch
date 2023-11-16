package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("addType")
    val addType: String,
    @SerializedName("bbbFancy")
    val bbbFancy: String,
    @SerializedName("bmProvider")
    val bmProvider: String,
    @SerializedName("channelNo")
    val channelNo: String,
    @SerializedName("competitionId")
    val competitionId: String,
    @SerializedName("competitionName")
    val competitionName: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("eventId")
    val eventId: String,
    @SerializedName("eventName")
    val eventName: String,
    @SerializedName("fancyAType")
    val fancyAType: String,
    @SerializedName("fancyProvider")
    val fancyProvider: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isResult")
    val isResult: Boolean,
    @SerializedName("mEventId")
    val mEventId: String,
    @SerializedName("mType")
    val mType: String,
    @SerializedName("marketId")
    val marketId: String,
    @SerializedName("marketIds")
    val marketIds: List<String>,
    @SerializedName("marketName")
    val marketName: String,
    @SerializedName("markets")
    val markets: List<Market>,
    @SerializedName("matchRunners")
    val matchRunners: List<MatchRunner>,
    @SerializedName("oddsProvider")
    val oddsProvider: String,
    @SerializedName("openDate")
    val openDate: String,
    @SerializedName("sportId")
    val sportId: String,
    @SerializedName("sportName")
    val sportName: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("unixDate")
    val unixDate: Int,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("__v")
    val v: Int
)