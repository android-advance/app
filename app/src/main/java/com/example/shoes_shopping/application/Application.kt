package com.example.shoes_shopping.application

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class Application : Application() {
    companion object {
        lateinit var instance: Application
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }
}