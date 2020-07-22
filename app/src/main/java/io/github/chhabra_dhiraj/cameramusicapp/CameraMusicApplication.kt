package io.github.chhabra_dhiraj.cameramusicapp

import android.app.Application
import timber.log.Timber

class CameraMusicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}