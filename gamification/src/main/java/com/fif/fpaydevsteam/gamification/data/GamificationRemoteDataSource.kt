package com.fif.fpaydevsteam.gamification.data

import com.fif.fpaydevsteam.gamification.utils.BaseDataSource
import javax.inject.Inject

class GamificationRemoteDataSource @Inject constructor(
    private val gamificatioService: GamificationService
) : BaseDataSource() {
}