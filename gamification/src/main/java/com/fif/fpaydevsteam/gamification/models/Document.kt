package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName

data class Document(
    @SerializedName("documentNumber")
    val documentNumber: String,
    @SerializedName("documentType")
    val documentType: String,
    @SerializedName("issuingCountry")
    val issuingCountry: String
)