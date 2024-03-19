package com.project.id4you.presentation.userRegistration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.id4you.common.Resource
import com.project.id4you.domain.useCase.loginUser.RegisterUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserRegistrationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(UserRegistrationState())
    val state: State<UserRegistrationState> = _state

    fun registerUser(email: String, password: String, passwordConfirm: String) {
        val unexpectedErrorMessage: String = "An unexpected error occurred."
        viewModelScope.launch {
            registerUserUseCase(email, password, passwordConfirm).onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        _state.value =
                            UserRegistrationState(error = result.message ?: unexpectedErrorMessage)
                    }

                    is Resource.Loading -> {
                        _state.value = UserRegistrationState(isLoading = true)
                    }

                    is Resource.Success -> {
                        _state.value = UserRegistrationState(isLoading = false, isSuccess = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}
