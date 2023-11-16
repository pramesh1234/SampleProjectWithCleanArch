package com.example.myapplication.service

import com.example.myapplication.model.EventsDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/v1-custom/getLiveMatches")
    suspend fun getSportsData():Response<EventsDataModel>
}
