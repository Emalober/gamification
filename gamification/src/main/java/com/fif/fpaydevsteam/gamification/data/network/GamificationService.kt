package com.fif.fpaydevsteam.gamification.data.network

import com.fif.fpaydevsteam.gamification.models.*
import retrofit2.Response
import retrofit2.http.*

const val headerCountry="country"

interface GamificationService {

    @GET("/loyalty/gamification/user/{id}")
    suspend fun getUser(@Path("id") id: String,
                        @Header(headerCountry) country: String): Response<UserInfo>

    @GET("/loyalty/gamification/user/bd/{id}")
    suspend fun getUserRegister(@Path("id") id: String,
                        @Header(headerCountry) country: String): Response<UserRegister>

    @GET("/loyalty/gamification/achievements/{id}")
    suspend fun getUserAchievements(@Path("id") id: String,
                                    @Header(headerCountry) country: String): Response<List<Achievement>>

    @GET("/loyalty/gamification/achievements")
    suspend fun getAchievements(@Header(headerCountry) country: String): Response<List<Achievement>>

    @POST("/loyalty/gamification/achievements/:id")
    suspend fun createAchievements(@Path("id") id: String,
                                   @Body new: Achievements,
                                   @Header(headerCountry) country: String): Response<Achievements>

    @GET("/loyalty/gamification/achievements")
    suspend fun getAwards(@Header(headerCountry) country: String): Response<List<Award>>

    @POST("/loyalty/gamification/user/add/:id/:points")
    suspend fun addPoints(@Path("id") id: String,
                                   @Path("points") points: Int,
                                  @Body new: String = "",
                                  @Header(headerCountry) country: String): Response<Any>
}