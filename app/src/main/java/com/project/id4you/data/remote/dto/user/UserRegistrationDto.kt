package com.project.id4you.data.remote.dto.user

data class UserRegistrationDto(
    val email: String,
    val password: String,
    val passwordConfirm: String,
    val name: String,
    val surname: String,
    val birthDate: String,
    val personalCode: String
)
