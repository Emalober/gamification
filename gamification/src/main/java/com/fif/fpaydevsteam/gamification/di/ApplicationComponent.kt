package com.fif.fpaydevsteam.gamification.di

import android.content.Context
import com.fif.fpaydevsteam.gamification.ui.GamificationViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent: ViewModelInjector {
    fun inject(context: Context)
}


interface ViewModelInjector {
    fun inject(gamificationViewModel: GamificationViewModel)
}
