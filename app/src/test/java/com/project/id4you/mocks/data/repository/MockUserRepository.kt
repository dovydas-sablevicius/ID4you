package com.project.id4you.mocks.data.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import com.project.id4you.domain.repository.UserRepository
import com.project.id4you.presentation.singleton.AuthToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockUserRepository : UserRepository {
    private val users = mutableListOf<User>()
    override suspend fun registerUser(
        email: String,
        password: String,
        passwordAgain: String,
        name: String,
        surname: String,
        birthDate: String,
        personalCode: String
    ): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            if (password == passwordAgain) {
                users.add(User(email, java.util.UUID.randomUUID().toString(), name, surname))
                emit(Resource.Success(Unit))
            } else {
                emit(Resource.Error("Passwords do not match"))
            }

        }

    }

    override suspend fun loginUser(email: String, password: String): Flow<Resource<User>> {
        return flow {
            emit(Resource.Loading())
            if (email == "test@test.com" && password == "password123") {
                emit(Resource.Success(User("test@test.com", "", "", "")))
                AuthToken.value = "TestToken"
            } else {
                emit(Resource.Error("Wrong Credentials"))
            }

        }
    }
}
