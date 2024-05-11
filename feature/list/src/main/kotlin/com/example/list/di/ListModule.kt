package com.example.list.di

import com.example.database.UniversitiesDao
import com.example.database.UniversitiesDatabase
import com.example.di.scope.FeatureScope
import com.example.list.data.remote.datasource.UniversitiesRemoteDataSource
import com.example.list.data.remote.services.UniversityService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class ListModule {

    @Provides
    @FeatureScope
    fun provideNewsDao(db: UniversitiesDatabase): UniversitiesDao = db.universitiesDao

    @Provides
    @FeatureScope
    fun provideNewsService(retrofit: Retrofit): UniversityService = retrofit.create(UniversityService::class.java)

    @Provides
    @FeatureScope
    fun provideRemoteDataSource(service: UniversityService) = UniversitiesRemoteDataSource(service)
}