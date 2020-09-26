package com.fif.fpaydevsteam.gamification.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fif.fpaydevsteam.gamification.BuildConfig
import com.fif.fpaydevsteam.gamification.data.GamificationRemoteDataSource
import com.fif.fpaydevsteam.gamification.data.GamificationRepository
import com.fif.fpaydevsteam.gamification.data.network.GamificationService
import com.fif.fpaydevsteam.gamification.ui.GamificationViewModel
import com.fif.fpaydevsteam.gamification.utils.ViewModelFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_DOMAIN)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideGamificatioService(retrofit: Retrofit): GamificationService = retrofit.create(
        GamificationService::class.java)

    @Singleton
    @Provides
    fun provideGamificatioRemoteDataSource(gamificatioService: GamificationService) =
        GamificationRemoteDataSource(gamificatioService)

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: GamificationRemoteDataSource) =
        GamificationRepository(remoteDataSource)
}

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(GamificationViewModel::class)
    abstract fun bindLineIncreaseViewModel(viewModel: GamificationViewModel): ViewModel

}