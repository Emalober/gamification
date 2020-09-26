package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class MaritalStatus(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)