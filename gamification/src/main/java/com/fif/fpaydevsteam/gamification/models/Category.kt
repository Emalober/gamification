package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val origin: String
)