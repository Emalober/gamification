package com.fif.fpaydevsteam.sample.gamification

import android.app.Application
import com.fif.fpaydevsteam.gamification.di.GamificationModule

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GamificationModule().init(this, "")

    }
}