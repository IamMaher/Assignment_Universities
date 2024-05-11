package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class University(
  val alphaTwoCode: String?,
  val name: String?,
  val country: String?,
  val webPage: String?,
  val stateProvince: String?
) : Parcelable