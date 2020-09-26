package com.fif.fpaydevsteam.gamification.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GamificationService {

    @GET("/loyalty/gamification/user/{id}")
    suspend fun getUser(@Path("id") id: String): Response<User>
}