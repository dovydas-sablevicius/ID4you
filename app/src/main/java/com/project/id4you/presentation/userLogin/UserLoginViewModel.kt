package com.project.id4you.presentation.userLogin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.loginUser.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserLoginViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(UserLoginState())
    val state: State<UserLoginState> = _state

    private fun loginUser(email: String, password: String) {
        loginUserUseCase(email, password).onEach { result ->
            when (result) {
                is Resource.Error -> {

                }

                is Resource.Loading -> {

                }

                is Resource.Success -> {

                }
            }
        }
    }
}