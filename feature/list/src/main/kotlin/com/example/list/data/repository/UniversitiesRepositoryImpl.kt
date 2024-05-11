package com.example.list.data.repository

import com.example.domain.model.University
import com.example.list.data.remote.datasource.UniversitiesRemoteDataSource
import com.example.list.data.local.datasource.UniversitiesLocalDataSource
import com.example.list.data.mapper.localToDomainEntity
import com.example.list.data.mapper.remoteToDomainEntity
import com.example.list.data.mapper.toLocalEntity
import javax.inject.Inject

class UniversitiesRepositoryImpl @Inject constructor(
    private val localDataSource: UniversitiesLocalDataSource,
    private val remoteDataSource: UniversitiesRemoteDataSource
) : IUniversitiesRepository {

    override suspend fun getUniversities(): List<University> {
        return try {
            val data = remoteDataSource.getUniversities()
            localDataSource.clear()
            localDataSource.insertUniversitiesList(data.toLocalEntity())
            data.remoteToDomainEntity()
        } catch (ex: Exception) {
            println(ex)
            localDataSource.getUniversitiesList().localToDomainEntity()
        }
    }
}