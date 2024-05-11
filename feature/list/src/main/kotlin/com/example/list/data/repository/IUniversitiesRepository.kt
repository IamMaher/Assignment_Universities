package com.example.list.data.repository

import com.example.domain.model.University

interface IUniversitiesRepository {
  suspend fun getUniversities(): List<University>
}