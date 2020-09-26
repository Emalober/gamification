package com.fif.fpaydevsteam.gamification.di

import android.content.Context

class GamificationModule {

    companion object {
        var applicationComponent: ApplicationComponent? = null
        internal lateinit var userKey: String
    }

    fun init(context: Context, userKey: String) {
        Companion.userKey = userKey
        appComponent().inject(context)
    }
}

private fun buildDagger(): ApplicationComponent {
    if (GamificationModule.applicationComponent == null) {
        GamificationModule.applicationComponent = DaggerApplicationComponent
            .builder()
            .build()
    }
    return GamificationModule.applicationComponent!!
}

fun appComponent(): ApplicationComponent {
    return buildDagger()
}
