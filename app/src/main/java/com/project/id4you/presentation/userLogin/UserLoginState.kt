package com.project.id4you.presentation.userLogin

import com.project.id4you.data.repository.model.User

data class UserLoginState(
    val isLoading: Boolean = false,
    val error: String = "",
    val user: User? = null
)