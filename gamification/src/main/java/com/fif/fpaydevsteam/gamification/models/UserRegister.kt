package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class UserRegister(
    @SerializedName("achievements")
    val achievements: List<Achievement>,
    @SerializedName("country")
    val country: String,
    @SerializedName("docNumber")
    val docNumber: String,
    @SerializedName("docType")
    val docType: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("experience")
    val experience: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("idUser")
    val idUser: String,
    @SerializedName("img64")
    val img64: String,
    @SerializedName("influence")
    val influence: Double,
    @SerializedName("phone")
    val phone: Phone,
    @SerializedName("points")
    val points: Points,
    @SerializedName("ranking")
    val ranking: Int
)