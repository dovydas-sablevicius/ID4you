package com.project.id4you.presentation.screens.userLogin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.loginUser.LoginUserUseCase
import com.project.id4you.presentation.singleton.AuthToken
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

    private fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            loginUserUseCase(email, password).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value =
                            UserLoginState(
                                error = result.message ?: ExceptionMessages.unexpectedErrorMessage
                            )
                    }

                    is Resource.Loading -> {
                        _state.value = UserLoginState(isLoading = true)
                    }

                    is Resource.Success -> {
                        AuthToken.value = result.data?.token ?: ""
                        _state.value =
                            UserLoginState(isLoading = false, isSuccess = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }


    fun onEvent(event: UserLoginEvent) {
        when (event) {
            is UserLoginEvent.EnteredEmail -> {
                _state.value = state.value.copy(email = event.value)
            }

            is UserLoginEvent.EnteredPassword -> {
                _state.value = state.value.copy(password = event.value)
            }

            UserLoginEvent.PressedLoginButton -> {
                loginUser(_state.value.email, _state.value.password)
            }
        }
    }
}
