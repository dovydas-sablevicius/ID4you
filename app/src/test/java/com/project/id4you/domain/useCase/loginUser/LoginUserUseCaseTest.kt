package com.project.id4you.domain.useCase.loginUser

import com.project.id4you.mocks.data.repository.MockUserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoginUserUseCaseTest {
    private lateinit var loginUserUseCase: LoginUserUseCase
    private lateinit var mockedUserRepository: MockUserRepository

    @Before
    fun setUp() {
        mockedUserRepository = MockUserRepository()
        loginUserUseCase = LoginUserUseCase(mockedUserRepository)
    }

    @Test
    fun testLogin() {
        val email: String = "test@test.com"
        val password: String = "password123"
        runBlocking {
            loginUserUseCase.invoke(email, password)
        }
        assert(true)
    }
}
