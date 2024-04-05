package com.project.id4you.data.repository.impl

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import com.project.id4you.mocks.data.repository.MockPocketBaseApi
import com.project.id4you.mocks.data.repository.MockPocketBaseApiHttpException
import com.project.id4you.mocks.data.repository.MockPocketBaseApiIOException
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UserRepositoryImplTest {

    private lateinit var userRepositoryImpl: UserRepositoryImpl


    @Test
    fun loginUser() {
        val pocketBaseApi = MockPocketBaseApi()
        userRepositoryImpl = UserRepositoryImpl(pocketBaseApi)
        val email: String = "test@test.com"
        val password: String = "password123"
        val user: User = User(email, "", "", "")
        val response: List<Resource<User>>
        runBlocking {
            response = userRepositoryImpl.loginUser(email, password).toList()
        }
        assert(response.first()::class == Resource.Loading<User>()::class)
        assert(response[1]::class == Resource.Success(user)::class)
        assert(response[1].data?.email == user.email)
    }

    @Test
    fun testLoginHttpExceptions() {
        val pocketBaseApi = MockPocketBaseApiHttpException()
        userRepositoryImpl = UserRepositoryImpl(pocketBaseApi)
        val email: String = "test@test.com"
        val password: String = "password123"
        var user: User = User(email, "", "", "")
        val response: List<Resource<User>>
        runBlocking {
            response = userRepositoryImpl.loginUser(email, password).toList()
        }
        assert(response.first()::class == Resource.Loading<User>()::class)
        assert(response[1]::class == Resource.Error<User>("HTTP 500 Response.error()")::class)
        assert(response[1].message == "HTTP 500 Response.error()")
    }

    @Test
    fun testLoginIOException() {
        val pocketBaseApi = MockPocketBaseApiIOException()
        userRepositoryImpl = UserRepositoryImpl(pocketBaseApi)
        val email: String = "test@test.com"
        val password: String = "password123"
        var user: User = User(email, "", "", "")
        val response: List<Resource<User>>
        runBlocking {
            response = userRepositoryImpl.loginUser(email, password).toList()
        }
        assert(response.first()::class == Resource.Loading<User>()::class)
        assert(response[1]::class == Resource.Error<User>("Couldn't reach server.")::class)
        assert(response[1].message == "Couldn't reach server.")
    }
}
