package com.example.myapplication.helper

import com.example.myapplication.model.Data
import com.example.myapplication.model.EventsDataModel
import com.example.myapplication.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
):ApiHelper{
    override suspend fun getSportsData() : Response<EventsDataModel> = apiService.getSportsData()
}