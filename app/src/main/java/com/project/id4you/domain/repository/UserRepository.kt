package com.project.id4you.domain.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun registerUser(
        email: String,
        password: String,
        passwordAgain: String,
        name: String,
        surname: String,
        birthDate: String,
        personalCode: String
    ): Flow<Resource<Unit>>

    suspend fun loginUser(email: String, password: String): Flow<Resource<User>>
}
