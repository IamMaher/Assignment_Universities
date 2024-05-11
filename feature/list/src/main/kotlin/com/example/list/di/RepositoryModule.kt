package com.example.list.di

import com.example.list.data.repository.IUniversitiesRepository
import com.example.list.data.repository.UniversitiesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindRepository(repository: UniversitiesRepositoryImpl): IUniversitiesRepository
}