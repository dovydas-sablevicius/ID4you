package com.project.id4you.presentation.screens.userLogin

data class UserLoginState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val email: String = "",
    val password: String = ""
)
