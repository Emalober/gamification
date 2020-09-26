package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Telephone(
    @SerializedName("areaCode")
    val areaCode: String,
    @SerializedName("countryCode")
    val countryCode: String,
    @SerializedName("isPrimary")
    val isPrimary: Boolean,
    @SerializedName("number")
    val number: String,
    @SerializedName("type")
    val type: TypeX
)