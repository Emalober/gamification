package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Achievement(
    @SerializedName("avaiable")
    val avaiable: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("experience")
    val experience: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("points")
    val points: Int,
    @SerializedName("type")
    val type: String
)