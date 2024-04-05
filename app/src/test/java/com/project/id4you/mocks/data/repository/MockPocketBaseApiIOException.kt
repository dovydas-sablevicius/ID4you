package com.project.id4you.mocks.data.repository

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import java.io.IOException

class MockPocketBaseApiIOException : PocketBaseApi {
    private val users = mutableListOf<UserDto>()

    init {
        users.add(
            UserDto(
                Record(
                    "",
                    "",
                    "",
                    "test@test.com",
                    false,
                    java.util.UUID.randomUUID().toString(),
                    "",
                    "",
                    false
                ),
                ""
            )
        )
    }

    override suspend fun registerUser(userRegistrationDto: UserRegistrationDto) {
        throw IOException()
    }

    override suspend fun loginUser(userLoginDto: UserLoginDto): UserDto {
        throw IOException()
    }

    override suspend fun getIdCards(authToken: String): IdCardsDto {
        TODO("Not yet implemented")
    }
}
