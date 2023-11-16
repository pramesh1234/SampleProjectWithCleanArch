package com.example.myapplication.repo

import Resource
import com.example.myapplication.helper.ApiResponse
import com.example.myapplication.helper.NetworkRequest
import com.example.myapplication.model.Data
import com.example.myapplication.service.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.Exception

interface InAppFilterRepository {
    suspend fun getInPlayList(): Flow<Resource<List<Data>>>
    class Impl @Inject constructor(val service: ApiService): InAppFilterRepository{
        override suspend fun getInPlayList():Flow<Resource<List<Data>>> = flow {
            emit(Resource.Loading())
            try{
           val data = NetworkRequest.process {
                service.getSportsData()
            }.run {
                when(this){
                    is ApiResponse.Success ->{
                       data?.data?:throw Exception("Error fetching data")
                    }
                    is ApiResponse.Failure->{
                        throw Exception(message)
                    }
                }

            }
                emit(Resource.Success(data = data))
        }
        catch (e:Exception){
            emit(Resource.Error(e.message.toString()))

        }
        }

    }




}