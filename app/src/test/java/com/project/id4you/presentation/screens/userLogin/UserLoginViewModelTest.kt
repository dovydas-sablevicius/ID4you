package com.project.id4you.presentation.screens.userLogin

import com.project.id4you.domain.repository.UserRepository
import com.project.id4you.domain.useCase.loginUser.LoginUserUseCase
import com.project.id4you.mocks.data.repository.MockUserRepository
import com.project.id4you.presentation.singleton.AuthToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserLoginViewModelTest {
    private lateinit var loginUserUseCase: LoginUserUseCase
    private lateinit var fakeUserRepository: UserRepository
    private lateinit var userLoginViewModel: UserLoginViewModel


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        fakeUserRepository = MockUserRepository()
        loginUserUseCase = LoginUserUseCase(fakeUserRepository)
        userLoginViewModel = UserLoginViewModel(loginUserUseCase)
        runBlocking {
            fakeUserRepository.registerUser("test@test.com", "password123", "password123")
            fakeUserRepository.registerUser("test1@test.com", "password123", "password123")
            fakeUserRepository.registerUser("test2@test.com", "password123", "password123")
        }

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testEnteredEmailEvent() {
        val email: String = "test@test.com"
        userLoginViewModel.onEvent(UserLoginEvent.EnteredEmail(email))
        assert(userLoginViewModel.state.value.email == email)
    }

    @Test
    fun testEnteredPasswordEvent() {
        val password: String = "password123"
        userLoginViewModel.onEvent(UserLoginEvent.EnteredPassword(password))
        assert(userLoginViewModel.state.value.password == password)
    }

    @Test
    fun testLoginUser() {
        val email: String = "test@test.com"
        val password: String = "password123"
        userLoginViewModel.onEvent(UserLoginEvent.EnteredEmail(email))
        userLoginViewModel.onEvent(UserLoginEvent.EnteredPassword(password))
        userLoginViewModel.onEvent(UserLoginEvent.PressedLoginButton)
        assert(userLoginViewModel.state.value.isSuccess)
        assert(AuthToken.value == "TestToken")
    }

    @Test
    fun testFailedLoginUser() {
        val email: String = "test1@test.com"
        val password: String = "password123"
        userLoginViewModel.onEvent(UserLoginEvent.EnteredEmail(email))
        userLoginViewModel.onEvent(UserLoginEvent.EnteredPassword(password))
        userLoginViewModel.onEvent(UserLoginEvent.PressedLoginButton)
        assert(userLoginViewModel.state.value.error == "Wrong Credentials")
    }
}
