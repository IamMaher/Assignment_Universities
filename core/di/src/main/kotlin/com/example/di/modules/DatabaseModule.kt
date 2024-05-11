package com.example.di.modules

import android.app.Application
import androidx.room.Room
import com.example.database.LocalDataSourcesKeys.UNIVERSITIES_DB_NAME
import com.example.database.UniversitiesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(appContext: Application): UniversitiesDatabase {
        return Room.databaseBuilder(appContext, UniversitiesDatabase::class.java, UNIVERSITIES_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}