package com.fif.fpaydevsteam.gamification.data

import com.fif.fpaydevsteam.gamification.data.network.GamificationService
import com.fif.fpaydevsteam.gamification.di.GamificationModule
import com.fif.fpaydevsteam.gamification.utils.BaseDataSource
import javax.inject.Inject

class GamificationRemoteDataSource @Inject constructor(
    private val gamificatioService: GamificationService
) : BaseDataSource() {

    suspend fun getUser(id: String) = getResult { gamificatioService.getUser(id, GamificationModule.country) }
    suspend fun getUserRegister(id: String) = getResult { gamificatioService.getUserRegister(id, GamificationModule.country) }
    suspend fun getUserAchievements(id: String) = getResult { gamificatioService.getUserAchievements(id, GamificationModule.country) }
    suspend fun getAchievements() = getResult { gamificatioService.getAchievements(GamificationModule.country) }
    suspend fun getAwards() = getResult { gamificatioService.getAwards(GamificationModule.country) }

}