package com.fif.fpaydevsteam.gamification.data

import javax.inject.Inject

class GamificationRepository @Inject constructor(
    private val remoteDataSource: GamificationRemoteDataSource
) {
}