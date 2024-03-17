package com.project.id4you.data.remote.dto

data class UserRegistrationDto(
    val email: String,
    val password: String,
    val passwordConfirm: String
)
