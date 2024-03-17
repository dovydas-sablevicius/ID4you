package com.project.id4you.domain.useCase.loginUser

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.User
import com.project.id4you.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<User>> {
        return repository.loginUser(email, password)
    }
}
