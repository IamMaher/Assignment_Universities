package com.example.list.data.remote.datasource

import com.example.list.data.remote.model.UniversitiesItem
import com.example.list.data.remote.services.UniversityService
import javax.inject.Inject

class UniversitiesRemoteDataSource @Inject constructor(private val universityService: UniversityService) {
   suspend fun getUniversities(): List<UniversitiesItem> {
    return universityService.getUniversities()
  }
}