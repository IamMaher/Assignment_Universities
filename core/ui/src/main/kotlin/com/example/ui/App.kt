package com.example.ui

import android.app.Application
import android.content.Context
import com.example.di.CoreComponent
import com.example.di.DaggerCoreComponent

class App : Application() {
    
    lateinit var coreComponent: CoreComponent

    companion object {

        /**
         * Obtain core dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun coreComponent(context: Context)= (context.applicationContext as? App)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()

        initCoreDependencyInjection()
    }
    

    /**
     * Initialize core dependency injection component.
     */
    private fun initCoreDependencyInjection() {
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }
}