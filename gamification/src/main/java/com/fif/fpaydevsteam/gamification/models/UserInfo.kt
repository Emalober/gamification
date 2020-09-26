package com.fif.fpaydevsteam.gamification.models


import com.google.gson.annotations.SerializedName


data class UserInfo(
    @SerializedName("additionalSurname")
    val additionalSurname: String,
    @SerializedName("address")
    val address: List<Any>,
    @SerializedName("birthdate")
    val birthdate: String,
    @SerializedName("category")
    val category: Category,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("document")
    val document: Document,
    @SerializedName("email")
    val email: List<Email>,
    @SerializedName("enrollmentDate")
    val enrollmentDate: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("isBankCustomer")
    val isBankCustomer: Boolean,
    @SerializedName("isEmployee")
    val isEmployee: Boolean,
    @SerializedName("lastSurname")
    val lastSurname: String,
    @SerializedName("maritalStatus")
    val maritalStatus: MaritalStatus,
    @SerializedName("middleName")
    val middleName: String,
    @SerializedName("nationality")
    val nationality: Nationality,
    @SerializedName("permissions")
    val permissions: List<Permission>,
    @SerializedName("programCountry")
    val programCountry: String,
    @SerializedName("telephone")
    val telephone: List<Telephone>,
    @SerializedName("updatedAt")
    val updatedAt: String
)