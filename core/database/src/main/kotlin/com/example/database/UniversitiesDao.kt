package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface UniversitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(universities: List<UniversityLocalEntity>)

    @Query("SELECT * FROM universities")
    suspend fun find(): List<UniversityLocalEntity>

    @Query("DELETE FROM universities")
    suspend  fun clear()

    @Transaction
    suspend fun deleteAndInsertInTransaction(news : List<UniversityLocalEntity>) {
        clear()
        insert(news)
    }
}