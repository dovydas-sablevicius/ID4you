package com.project.id4you.presentation.userLogin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.loginUser.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserLoginViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(UserLoginState())
    val state: State<UserLoginState> = _state

    fun loginUser(email: String, password: String) {
        val unexpectedErrorMessage: String = "An unexpected error occurred."
        viewModelScope.launch {
            loginUserUseCase(email, password).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value =
                            UserLoginState(error = result.message ?: unexpectedErrorMessage)
                    }

                    is Resource.Loading -> {
                        _state.value = UserLoginState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _state.value = UserLoginState(isLoading = false, user = result.data)
                    }
                }
            }.launchIn(this)
        }
    }
}
