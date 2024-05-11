package com.example.list.data.remote.model

import com.squareup.moshi.Json

data class UniversitiesItem(
    @Json(name = "alpha_two_code")
    val alphaTwoCode: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "domains")
    val domains: List<String>?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "state-province")
    val stateProvince: String?,
    @Json(name = "web_pages")
    val webPages: List<String?>?
)