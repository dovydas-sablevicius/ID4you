package com.project.id4you.presentation.screens.userLogin

data class UserLoginState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val email: String = "test@gmail.com",
    val password: String = "12345678"
)
