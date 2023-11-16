package com.example.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplicationApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}