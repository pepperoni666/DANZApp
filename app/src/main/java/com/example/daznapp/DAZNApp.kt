package com.example.daznapp

import android.app.Application
import com.example.daznapp.di.remoteModule
import com.example.daznapp.di.repositoryModule
import com.example.daznapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DAZNApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@DAZNApp)
            modules(koinModulesList)
        }
    }

    companion object {
        private val koinModulesList = listOf(
            remoteModule,
            repositoryModule,
            viewModelModule,
        )
    }
}