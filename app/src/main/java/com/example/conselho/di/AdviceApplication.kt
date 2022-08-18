package com.example.conselho.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AdviceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AdviceApplication)
            modules(listOf(networkModule, domainModule, dataModule, presentationModule))
        }
    }
}