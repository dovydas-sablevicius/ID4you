package com.project.id4you.presentation.userLogin

data class UserRegistrationState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false
)
