package com.project.id4you.data.repository.Impl

import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import com.project.id4you.data.remote.dto.user.toUser
import com.project.id4you.data.repository.model.User
import com.project.id4you.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: PocketBaseApi
) : UserRepository {
    override suspend fun registerUser(
        email: String,
        password: String,
        passwordAgain: String
    ): Flow<Resource<Unit>> =
        flow {
            try {
                emit(Resource.Loading())
                val userRegistrationDto: UserRegistrationDto =
                    UserRegistrationDto(email, password, passwordAgain)
                val response: Unit = api.registerUser(userRegistrationDto)
                emit(Resource.Success(response))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.httpExceptionMessage))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.ioExceptionMessage))
            }
        }

    override suspend fun loginUser(email: String, password: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading())
        try {
            val userLoginDto: UserLoginDto = UserLoginDto(email, password)
            val user: User = api.loginUser(userLoginDto).toUser()
            emit(Resource.Success(user))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.httpExceptionMessage))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.ioExceptionMessage))
        }
    }

}
