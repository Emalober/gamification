package com.fif.fpaydevsteam.sample.gamification

import android.app.Application
import com.fif.fpaydevsteam.gamification.di.GamificationModule
import com.fif.fpaydevsteam.gamification.models.Customer

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        GamificationModule().init(this, Customer("172041957", "01", "CL"), "CL")

    }
}