package com.example.myapplication.helper

import com.example.myapplication.model.Data
import com.example.myapplication.model.EventsDataModel
import retrofit2.Response

interface ApiHelper {
    suspend fun getSportsData() : Response<EventsDataModel>
}