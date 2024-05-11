package com.example.di

import android.app.Application
import android.content.Context
import com.example.database.UniversitiesDatabase
import com.example.di.modules.ContextModule
import com.example.di.modules.DatabaseModule
import com.example.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
    ]
)
interface CoreComponent {
    fun context(): Context
    fun universitiesDatabase(): UniversitiesDatabase
    fun retrofit(): Retrofit

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }
}