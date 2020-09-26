package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Points(
    @SerializedName("dateToExpire")
    val dateToExpire: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("toExpire")
    val toExpire: Int
)