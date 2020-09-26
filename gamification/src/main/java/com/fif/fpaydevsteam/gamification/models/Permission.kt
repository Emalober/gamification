package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Permission(
    @SerializedName("name")
    val name: String,
    @SerializedName("objectRef")
    val objectRef: String,
    @SerializedName("value")
    val value: Boolean
)