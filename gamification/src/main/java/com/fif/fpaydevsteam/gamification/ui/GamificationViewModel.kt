package com.fif.fpaydevsteam.gamification.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fif.fpaydevsteam.gamification.data.GamificationRepository
import com.fif.fpaydevsteam.gamification.di.GamificationModule
import com.fif.fpaydevsteam.gamification.di.appComponent
import com.fif.fpaydevsteam.gamification.models.Achievements
import com.fif.fpaydevsteam.gamification.models.UserInfo
import com.fif.fpaydevsteam.gamification.models.UserRegister
import com.fif.fpaydevsteam.gamification.utils.Resource
import javax.inject.Inject

class GamificationViewModel : ViewModel() {

    @Inject
    lateinit var repository: GamificationRepository

    init {
        appComponent().inject(this)
    }

    val userInfo: LiveData<Resource<UserInfo>> = repository.getUser(GamificationModule.userKey)
    val userRegister: LiveData<Resource<UserRegister>> = repository.getUserRegister(GamificationModule.userKey)
    val userAchievements: LiveData<Resource<Achievements>> = repository.getUserAchievements(GamificationModule.userKey)
    val achievements: LiveData<Resource<Achievements>> = repository.getAchievements()

    val hasChanceToPlay = MutableLiveData<Boolean>(true)
}