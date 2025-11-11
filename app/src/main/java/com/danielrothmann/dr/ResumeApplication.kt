package com.danielrothmann.dr

import android.app.Application
import com.danielrothmann.dr.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ResumeApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ResumeApplication)
            modules(appModule)
        }
    }
    // create apk
}
