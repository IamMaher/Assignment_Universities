package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UniversitiesListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(universities: List<UniversityLocalEntity>)

    @Query("SELECT * FROM universities")
    fun getUniversities(): List<UniversityLocalEntity>

    @Query("DELETE FROM universities")
    fun deleteAll()

}