package com.fif.fpaydevsteam.gamification.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fif.fpaydevsteam.gamification.data.GamificationRepository
import com.fif.fpaydevsteam.gamification.di.GamificationModule
import com.fif.fpaydevsteam.gamification.di.appComponent
import com.fif.fpaydevsteam.gamification.models.*
import com.fif.fpaydevsteam.gamification.utils.Resource
import javax.inject.Inject
import kotlin.random.Random

class GamificationViewModel : ViewModel() {

    @Inject
    lateinit var repository: GamificationRepository

    val addPoints: LiveData<Resource<Any>>

    val hasChanceToPlay = MutableLiveData<Boolean>(true)
    val hasAPrize = MutableLiveData<Award>(null)
    private var increasePoints: MutableLiveData<Int> = MutableLiveData()

    init {
        appComponent().inject(this)

        addPoints = Transformations.switchMap(increasePoints) {
            repository.addPoints(GamificationModule.userKey, it)
        }
    }

    val userInfo: LiveData<Resource<UserInfo>> = repository.getUser(GamificationModule.userKey)
    val userRegister: LiveData<Resource<UserRegister>> = repository.getUserRegister(GamificationModule.userKey)
    val userAchievements: LiveData<Resource<List<Achievement>>> = repository.getUserAchievements(GamificationModule.userKey)
    val achievements: LiveData<Resource<List<Achievement>>> = repository.getAchievements()
    val awardes: LiveData<Resource<List<Award>>> = repository.getAwards()

    fun addPoints(points: Int) {
        increasePoints.value = points
    }

    fun createEasterEgg() {
        if(hasAPrize.value != null) return

        val maxAward = awardes.value?.data?.size
        maxAward?.let { n ->
            val sor = Random.nextInt(0, n*3)
            if (sor < maxAward) {
                hasAPrize.value = awardes.value?.data?.get(sor)
            } else {
                hasAPrize.value = Award(true, "500 de experiencia","exp", "exp", "exp","exp")
            }
        }
    }
}