package com.fif.fpaydevsteam.gamification.di

import android.app.Application

class GamificationApplication : Application() {

    companion object {
        var applicationComponent: ApplicationComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent().inject(this)
    }
}

private fun buildDagger(): ApplicationComponent {
    if (GamificationApplication.applicationComponent == null) {
        GamificationApplication.applicationComponent = DaggerApplicationComponent
            .builder()
            .build()
    }
    return GamificationApplication.applicationComponent!!
}

fun appComponent(): ApplicationComponent {
    return buildDagger()
}
