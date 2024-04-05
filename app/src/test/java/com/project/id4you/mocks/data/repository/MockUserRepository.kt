package com.project.id4you.mocks.data.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import com.project.id4you.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockUserRepository : UserRepository {
    val users = mutableListOf<User>()

    override suspend fun registerUser(
        email: String,
        password: String,
        passwordAgain: String
    ): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            users.add(User(email, java.util.UUID.randomUUID().toString(), "", ""))
            emit(Resource.Success(Unit))
        }

    }

    override suspend fun loginUser(email: String, password: String): Flow<Resource<User>> {
        return flow {
            emit(Resource.Loading())
            val user: User? = users.find { user: User -> user.email == email }
            if (user != null) {
                emit(Resource.Success(user))
            } else {
                emit(Resource.Error(message = "Invalid Credentials"))
            }
        }
    }
}
