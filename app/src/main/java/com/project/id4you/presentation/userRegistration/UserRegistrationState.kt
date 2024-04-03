package com.project.id4you.presentation.userRegistration

data class UserRegistrationState(
    val email: String = "",
    val password: String = "",
    val passwordAgain: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
)
