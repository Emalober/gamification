package com.fif.fpaydevsteam.gamification.data.network

import com.fif.fpaydevsteam.gamification.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GamificationService {

    @GET("/loyalty/gamification/user/{id}")
    suspend fun getUser(@Path("id") id: String): Response<UserInfo>

    @GET("/loyalty/gamification/achievements/{id}")
    suspend fun getUserAchievements(@Path("id") id: String): Response<Achievements>

    @GET("/loyalty/gamification/achievements")
    suspend fun getAchievements(): Response<Achievements>

}