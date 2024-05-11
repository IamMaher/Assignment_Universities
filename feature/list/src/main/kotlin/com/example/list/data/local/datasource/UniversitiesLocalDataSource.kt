package com.example.list.data.local.datasource

import com.example.database.UniversitiesDao
import com.example.database.UniversityLocalEntity
import javax.inject.Inject

class UniversitiesLocalDataSource @Inject constructor(private val universitiesDao: UniversitiesDao) {
  suspend fun insertUniversitiesList(list: List<UniversityLocalEntity>) {
    universitiesDao.insert(list)
  }

  suspend fun clear() {
    return universitiesDao.clear()
  }

  suspend fun getUniversitiesList(): List<UniversityLocalEntity> {
    return universitiesDao.find()
  }
}