package com.fif.fpaydevsteam.gamification.di

import android.app.Application
import dagger.Component
import javax.inject.Singleton

class GamificationApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
    
}

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface ApplicationComponent {
    fun inject(gamificationApplication: GamificationApplication)
}
