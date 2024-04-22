package com.project.id4you.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class UserRegistrationDto(
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val name: String,
    val surname: String,
    @SerializedName("birth_date")
    val birthDate: String,
    @SerializedName("personal_code")
    val personalCode: String
)
