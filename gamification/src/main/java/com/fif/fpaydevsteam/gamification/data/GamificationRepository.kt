package com.fif.fpaydevsteam.gamification.data

import com.fif.fpaydevsteam.gamification.utils.performGetOperation
import javax.inject.Inject

class GamificationRepository @Inject constructor(
    private val remoteDataSource: GamificationRemoteDataSource
) {

    fun getUser(id: String) = performGetOperation { remoteDataSource.getUser(id) }
    fun getUserRegister(id: String) = performGetOperation { remoteDataSource.getUserRegister(id) }
    fun getUserAchievements(id: String) = performGetOperation { remoteDataSource.getUserAchievements(id) }
    fun getAchievements() = performGetOperation { remoteDataSource.getAchievements() }
    fun getAwards() = performGetOperation { remoteDataSource.getAwards() }

}