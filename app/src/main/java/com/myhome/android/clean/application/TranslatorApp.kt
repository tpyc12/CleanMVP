package com.myhome.android.clean.application

import android.app.Application
import com.myhome.android.clean.di.application
import com.myhome.android.clean.di.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}