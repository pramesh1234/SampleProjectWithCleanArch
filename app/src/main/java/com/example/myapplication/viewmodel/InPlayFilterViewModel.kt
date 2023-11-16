package com.example.myapplication.viewmodel

import Resource
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Data
import com.example.myapplication.repo.InAppFilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class InPlayFilterViewModel  @Inject constructor(
    private val repository: InAppFilterRepository) : ViewModel() {
suspend fun getListOfEvents(): Flow<Resource<List<Data>>> {
    return repository.getInPlayList()
}
}