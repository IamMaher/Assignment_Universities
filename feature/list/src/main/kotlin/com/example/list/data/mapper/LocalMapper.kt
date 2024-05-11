package com.example.list.data.mapper

import com.example.database.UniversityLocalEntity
import com.example.list.data.remote.model.UniversitiesItem

fun  List<UniversitiesItem>.toLocalEntity(): List<UniversityLocalEntity> {
  return map {
    UniversityLocalEntity(
      alphaTwoCode = it.alphaTwoCode.orEmpty(),
      name = it.name.orEmpty(),
      country = it.country.orEmpty() ,
      stateProvince = it.stateProvince.orEmpty(),
       webPage = it.webPages?.firstOrNull().orEmpty()
    )
  }
}