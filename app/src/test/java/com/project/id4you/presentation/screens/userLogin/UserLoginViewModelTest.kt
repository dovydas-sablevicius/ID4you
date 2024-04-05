package com.project.id4you.presentation.screens.userLogin

import com.project.id4you.domain.repository.UserRepository
import com.project.id4you.domain.useCase.loginUser.LoginUserUseCase
import com.project.id4you.mocks.data.repository.MockUserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UserLoginViewModelTest {
    private lateinit var loginUserUseCase: LoginUserUseCase
    private lateinit var fakeUserRepository: UserRepository
    private lateinit var userLoginViewModel: UserLoginViewModel


    @Before
    fun setUp() {
        fakeUserRepository = MockUserRepository()
        loginUserUseCase = LoginUserUseCase(fakeUserRepository)
        userLoginViewModel = UserLoginViewModel(loginUserUseCase)
        runBlocking {
            fakeUserRepository.registerUser("test@test.com", "password123", "password123")
            fakeUserRepository.registerUser("test1@test.com", "password123", "password123")
            fakeUserRepository.registerUser("test2@test.com", "password123", "password123")
        }
        userLoginViewModel
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

//    @Test
//    fun testLoginUser() {
//        val email: String = "test@test.com"
//        val password: String = "password123"
//        userLoginViewModel.onEvent(UserLoginEvent.EnteredEmail(email))
//        userLoginViewModel.onEvent(UserLoginEvent.EnteredPassword(password))
//        userLoginViewModel.onEvent(UserLoginEvent.PressedLoginButton)
//        assert(userLoginViewModel.state.value.isSuccess)
//    }
}
