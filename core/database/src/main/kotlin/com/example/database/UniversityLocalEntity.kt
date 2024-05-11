package com.example.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.database.LocalDataSourcesKeys.ALPHA_2_CODES
import com.example.database.LocalDataSourcesKeys.COUNTRY
import com.example.database.LocalDataSourcesKeys.NAME
import com.example.database.LocalDataSourcesKeys.STATE
import com.example.database.LocalDataSourcesKeys.UNIVERSITIES_TABLE
import com.example.database.LocalDataSourcesKeys.WEB_PAGE

@Entity(tableName = UNIVERSITIES_TABLE)
data class UniversityLocalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(NAME) val name: String,
    @ColumnInfo(COUNTRY) val country: String,
    @ColumnInfo(WEB_PAGE) val webPage: String,
    @ColumnInfo(STATE) val stateProvince: String,
    @ColumnInfo(ALPHA_2_CODES) val alphaTwoCode: String,
)