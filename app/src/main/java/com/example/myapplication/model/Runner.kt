package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class Runner(
    @SerializedName("name")
    val name: String,
    @SerializedName("selectionId")
    val selectionId: Int
)