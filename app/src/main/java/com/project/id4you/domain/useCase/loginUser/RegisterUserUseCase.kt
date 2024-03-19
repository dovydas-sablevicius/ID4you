package com.project.id4you.domain.useCase.loginUser

import com.project.id4you.common.Resource
import com.project.id4you.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        passwordConfirm: String
    ): Flow<Resource<Unit>> {
        return repository.registerUser(email, password, passwordConfirm)
    }
}
