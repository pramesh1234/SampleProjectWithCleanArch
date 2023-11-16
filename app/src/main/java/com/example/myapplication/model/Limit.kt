package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class Limit(
    @SerializedName("baseCurrency")
    val baseCurrency: Boolean,
    @SerializedName("delay")
    val delay: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("maxPL")
    val maxPL: Int,
    @SerializedName("maxStake")
    val maxStake: Int,
    @SerializedName("minStake")
    val minStake: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("oddsLimit")
    val oddsLimit: Int,
    @SerializedName("preMaxPL")
    val preMaxPL: Int,
    @SerializedName("preMaxStake")
    val preMaxStake: Int,
    @SerializedName("preMinStake")
    val preMinStake: Int
)