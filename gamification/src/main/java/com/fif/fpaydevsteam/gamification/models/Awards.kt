package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Awards(
    @SerializedName("payload")
    val awards: List<Award>
)