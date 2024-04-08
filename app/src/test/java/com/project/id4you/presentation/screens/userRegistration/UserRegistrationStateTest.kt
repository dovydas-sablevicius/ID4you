package com.project.id4you.presentation.screens.userRegistration

import org.junit.Test

class UserRegistrationStateTest {
    @Test
    fun testDefaultRegistrationState() {
        val defaultState = generateDefaultRegistrationState()
        assert(!defaultState.isLoading)
        assert(defaultState.error == "")
        assert(!defaultState.isSuccess)
        assert(defaultState.email == "")
        assert(defaultState.password == "")
        assert(defaultState.passwordAgain == "")
    }

    @Test
    fun testLoadingRegistrationState() {
        val loadingState = generateRegistrationStateLoading()
        assert(loadingState.isLoading)
        assert(!loadingState.isSuccess)
        assert(loadingState.error == "")
        assert(loadingState.email == "")
        assert(loadingState.password == "")
        assert(loadingState.passwordAgain == "")
    }

    @Test
    fun testSuccessRegistrationState() {
        val email: String = "test@test.com"
        val password: String = "0123456789"
        val passwordAgain: String = "0123456789"

        val successState = generateRegistrationStateSuccess(email, password, passwordAgain)

        assert(successState.isSuccess)
        assert(!successState.isLoading)
        assert(successState.error == "")
        assert(successState.email == email)
        assert(successState.password == password)
        assert(successState.passwordAgain == passwordAgain)
    }

    @Test
    fun testErrorRegistrationState() {
        val error: String = "Unexpected Error"
        val errorState = generateRegistrationStateError(error)

        assert(!errorState.isSuccess)
        assert(!errorState.isLoading)
        assert(errorState.error == error)
        assert(errorState.email == "")
        assert(errorState.password == "")
        assert(errorState.passwordAgain == "")
    }
}

fun generateDefaultRegistrationState(): UserRegistrationState {
    return UserRegistrationState()
}

fun generateRegistrationStateError(error: String): UserRegistrationState {
    return UserRegistrationState(error = error)
}

fun generateRegistrationStateLoading(): UserRegistrationState {
    return UserRegistrationState(isLoading = true)
}

fun generateRegistrationStateSuccess(
    email: String,
    password: String,
    passwordAgain: String
): UserRegistrationState {
    return UserRegistrationState(
        email = email,
        password = password,
        passwordAgain = passwordAgain,
        isSuccess = true
    )
}
