package com.fif.fpaydevsteam.gamification.di

import com.fif.fpaydevsteam.gamification.data.GamificationRemoteDataSource
import com.fif.fpaydevsteam.gamification.data.GamificationRepository
import com.fif.fpaydevsteam.gamification.data.GamificationService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


interface ViewModelInjector {
    //fun inject(linkAccountViewModel: LinkAccountViewModel)
}

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl("https://gamification.mock.com/api/")
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