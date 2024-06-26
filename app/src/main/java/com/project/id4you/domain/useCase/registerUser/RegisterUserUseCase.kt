package com.project.id4you.domain.useCase.registerUser

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
        passwordConfirm: String,
        name: String,
        surname: String,
        birthDate: String,
        personalCode: String
    ): Flow<Resource<Unit>> {
        return repository.registerUser(
            email,
            password,
            passwordConfirm,
            name,
            surname,
            birthDate,
            personalCode
        )
    }
}
