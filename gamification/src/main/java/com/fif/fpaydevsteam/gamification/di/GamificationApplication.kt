package com.fif.fpaydevsteam.gamification.di

import android.content.Context
import com.fif.fpaydevsteam.gamification.models.Customer

class GamificationModule {

    companion object {
        var applicationComponent: ApplicationComponent? = null
        internal lateinit var userKey: String
        internal lateinit var country: String
    }

    fun init(context: Context, customer: Customer, country: String) {
        Companion.userKey = "Ka7duh7yBgPxv3hgXXCtVPpgWMqTpDlytZH0gP50vB8=" //customer.generateKey()
        Companion.country = country
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
