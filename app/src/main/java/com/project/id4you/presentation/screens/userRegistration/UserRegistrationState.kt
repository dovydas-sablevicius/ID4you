package com.project.id4you.presentation.screens.userRegistration

data class UserRegistrationState(
    val email: String = "",
    val password: String = "",
    val passwordAgain: String = "",
    val name: String = "",
    val surname: String = "",
    val birthDate: String = "",
    val personalCode: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false
)
