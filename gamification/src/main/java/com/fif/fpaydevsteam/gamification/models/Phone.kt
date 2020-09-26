package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Phone(
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("number")
    val number: String
)