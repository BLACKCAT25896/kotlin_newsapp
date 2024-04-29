package com.example.kotlinbaba

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KotlinBabaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}