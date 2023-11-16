package com.example.myapplication.di

import com.example.myapplication.model.Constant
import com.example.myapplication.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object ApiModule {
    @Provides
    fun provideApiService(builder: Retrofit.Builder): ApiService {
        return builder.baseUrl(Constant.BASE_URL)
            .build().create(ApiService::class.java)
    }
}