package com.example.list.domain.usecase

import com.example.domain.coroutines.BaseCoroutinesUseCase
import com.example.domain.coroutines.None
import com.example.domain.model.University
import com.example.list.data.repository.IUniversitiesRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class GetUniversitiesUseCase @Inject constructor(private val universitiesRepository: IUniversitiesRepository) :
    BaseCoroutinesUseCase<List<University>, None>(Dispatchers.IO) {

    override suspend fun buildUseCase(params: None?): List<University> = universitiesRepository.getUniversities()
}