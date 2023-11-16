package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class EventsDataModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String
)