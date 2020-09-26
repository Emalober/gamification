package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Email(
    @SerializedName("address")
    val address: String,
    @SerializedName("isPrimary")
    val isPrimary: Boolean,
    @SerializedName("type")
    val type: Type
)