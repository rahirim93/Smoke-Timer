package com.example.smoketimer

import android.app.Application

class MyAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MyAppRepository.initialize(this)
    }
}