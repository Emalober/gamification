package com.fif.fpaydevsteam.gamification.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fif.fpaydevsteam.gamification.data.GamificationRepository
import com.fif.fpaydevsteam.gamification.models.Achievements
import com.fif.fpaydevsteam.gamification.models.UserInfo
import com.fif.fpaydevsteam.gamification.utils.Resource
import javax.inject.Inject

class GamificationViewModel @Inject constructor(
    private val repository: GamificationRepository
) : ViewModel() {

    private val userId = "XMNYRotEot-iUfDbvWo9ZfvXxM2AvDgf3UVDYMqa7so="

    val userInfo: LiveData<Resource<UserInfo>> = repository.getUser(userId)
    val userAchievements: LiveData<Resource<Achievements>> = repository.getUserAchievements(userId)
    val achievements: LiveData<Resource<Achievements>> = repository.getAchievements()

}