package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Award(
    @SerializedName("avaiable")
    val avaiable: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("img64")
    val img64: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String
)