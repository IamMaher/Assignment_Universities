package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.LocalDataSourcesKeys.DB_VERSION

@Database(entities = [UniversityLocalEntity::class], version = DB_VERSION, exportSchema = false)
abstract class UniversitiesDatabase : RoomDatabase() {
  abstract val universitiesDao : UniversitiesDao
}