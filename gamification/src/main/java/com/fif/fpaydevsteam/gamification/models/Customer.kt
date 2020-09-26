package com.fif.fpaydevsteam.gamification.models

import android.util.Base64
import java.security.MessageDigest

class Customer(
    var documentNumber: String,
    var documentType: String,
    var issuingCountry: String
) {
    override fun toString(): String {
        return issuingCountry + documentType + documentNumber
    }

    fun generateKey(): String {
        val bytes = this.toString().toByteArray(Charsets.UTF_8)
        val md = MessageDigest.getInstance("SHA-256")
        return Base64.encodeToString(md.digest(bytes), Base64.DEFAULT);
    }
}