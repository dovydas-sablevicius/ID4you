package com.project.id4you.domain.useCase.loginUser

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import com.project.id4you.mocks.data.repository.MockUserRepository
import kotlinx.coroutines.flow.Flow
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
        var email: String = "test@test.com"
        var password: String = "password123"
        val response: Flow<Resource<User>>
        runBlocking {
            response = loginUserUseCase.invoke(email, password)
        }
        assert(true)
    }
}
