package com.example.list.data.remote.services

import com.example.list.data.remote.model.UniversitiesItem
import com.example.network.Constant.COUNTRY_KEY
import com.example.network.Constant.SEARCH_PATH
import com.example.network.Constant.UAE
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityService {
  @GET(SEARCH_PATH)
  suspend fun getUniversities(@Query(COUNTRY_KEY) country: String = UAE): List<UniversitiesItem>
}