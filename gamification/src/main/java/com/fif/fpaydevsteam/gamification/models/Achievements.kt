package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Achievements(
    @SerializedName("payload")
    val achievements: List<Achievement>
)