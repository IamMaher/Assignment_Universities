package com.example.list.data.mapper

import com.example.database.UniversityLocalEntity
import com.example.domain.model.University
import com.example.list.data.remote.model.UniversitiesItem

fun List<UniversitiesItem>.remoteToDomainEntity(): List<University> {
  return map {
    University(
      alphaTwoCode = it.alphaTwoCode,
      name = it.name,
      country = it.country,
      webPage = it.webPages?.firstOrNull(),
      stateProvince = it.stateProvince
    )
  }
}

fun List<UniversityLocalEntity>.localToDomainEntity(): List<University> {
  return map {
    University(
      alphaTwoCode = it.alphaTwoCode,
      name = it.name,
      country = it.country,
      webPage = it.webPage,
      stateProvince = it.stateProvince
    )
  }
}