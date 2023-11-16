package com.example.myapplication.di

import com.example.myapplication.repo.InAppFilterRepository
import com.example.myapplication.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
        fun provideRepository(
            service: ApiService
        ): InAppFilterRepository {
            return InAppFilterRepository.Impl(service)
        }
    }
