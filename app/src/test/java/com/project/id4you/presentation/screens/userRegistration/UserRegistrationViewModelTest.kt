package com.project.id4you.presentation.screens.userRegistration

import com.project.id4you.domain.repository.UserRepository
import com.project.id4you.domain.useCase.registerUser.RegisterUserUseCase
import com.project.id4you.mocks.data.repository.MockUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserRegistrationViewModelTest {
    private lateinit var registerUserUseCase: RegisterUserUseCase
    private lateinit var fakeUserRepository: UserRepository
    private lateinit var userRegisterViewModel: UserRegistrationViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        fakeUserRepository = MockUserRepository()
        registerUserUseCase = RegisterUserUseCase(fakeUserRepository)
        userRegisterViewModel = UserRegistrationViewModel(registerUserUseCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testEnteredEmailEvent() {
        val email: String = "test@test.com"
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredEmail(email))
        assert(userRegisterViewModel.state.value.email == email)
    }

    @Test
    fun testEnteredPasswordEvent() {
        val password: String = "password123"
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPassword(password))
        assert(userRegisterViewModel.state.value.password == password)
    }

    @Test
    fun testEnteredPasswordAgainEvent() {
        val passwordAgain: String = "password123"
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPasswordAgain(passwordAgain))
        assert(userRegisterViewModel.state.value.passwordAgain == passwordAgain)
    }

    @Test
    fun testRegisterUser() {
        val email: String = "test@test.com"
        val password: String = "password123"
        val passwordAgain: String = "password123"
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredEmail(email))
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPassword(password))
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPasswordAgain(passwordAgain))
        userRegisterViewModel.onEvent(UserRegistrationEvent.PressedRegisterButton)
        assert(userRegisterViewModel.state.value.isSuccess)
    }

    @Test
    fun testFailedRegisterUser() {
        val email: String = "test@test.com"
        val password: String = "password123"
        val passwordAgain: String = "password1"
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredEmail(email))
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPassword(password))
        userRegisterViewModel.onEvent(UserRegistrationEvent.EnteredPasswordAgain(passwordAgain))
        userRegisterViewModel.onEvent(UserRegistrationEvent.PressedRegisterButton)
        assert(userRegisterViewModel.state.value.error == "Passwords do not match")
    }


}
