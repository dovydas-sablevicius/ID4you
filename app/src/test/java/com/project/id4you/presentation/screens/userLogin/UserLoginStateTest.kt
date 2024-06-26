package com.project.id4you.presentation.screens.userLogin

import junit.framework.TestCase.assertTrue
import org.junit.Test

class UserLoginStateTest {
    @Test
    fun testDefaultLoginState() {
        val defaultState = generateDefaultLoginState()
        assertTrue("State is loading", !defaultState.isLoading)
        assertTrue("Error is not empty", defaultState.error == "")
        assertTrue("State is success", !defaultState.isSuccess)
        assertTrue("Email is not empty", defaultState.email == "")
        assertTrue("Password is not empty", defaultState.password == "")
    }

    @Test
    fun testLoadingLoginState() {
        val loadingState = generateLoginStateLoading()
        assert(loadingState.isLoading)
        assert(!loadingState.isSuccess)
        assert(loadingState.error == "")
        assert(loadingState.email == "")
        assert(loadingState.password == "")
    }

    @Test
    fun testSuccessLoginState() {
        val email: String = "test@test.com"
        val password: String = "0123456789"

        val successState = generateLoginStateSuccess(email, password)

        assert(successState.isSuccess)
        assert(!successState.isLoading)
        assert(successState.error == "")
        assert(successState.email == email)
        assert(successState.password == password)
    }

    @Test
    fun testErrorLoginState() {
        val error: String = "Unexpected Error"
        val errorState = generateLoginStateError(error)

        assert(!errorState.isSuccess)
        assert(!errorState.isLoading)
        assert(errorState.error == error)
        assert(errorState.email == "")
        assert(errorState.password == "")
    }
}

fun generateDefaultLoginState(): UserLoginState {
    return UserLoginState()
}

fun generateLoginStateError(error: String): UserLoginState {
    return UserLoginState(error = error)
}

fun generateLoginStateLoading(): UserLoginState {
    return UserLoginState(true)
}

fun generateLoginStateSuccess(email: String, password: String): UserLoginState {
    return UserLoginState(email = email, password = password, isSuccess = true)
}
