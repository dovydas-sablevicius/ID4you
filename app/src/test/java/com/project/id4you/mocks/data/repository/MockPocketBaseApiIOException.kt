package com.project.id4you.mocks.data.repository

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardDto
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import java.io.IOException

class MockPocketBaseApiIOException : PocketBaseApi {
    private val users = mutableListOf<UserDto>()
    private val cards = mutableListOf<IdCardsDto>()

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

    init {
        cards.add(
            IdCardsDto(
                arrayListOf(
                    IdCardDto(
                        collectionId = "",
                        collectionName = "",
                        created = "",
                        id = "id1",
                        name = "Card 1",
                        photos = listOf(),
                        updated = "",
                        userRelation = ""
                    ),
                    IdCardDto(
                        collectionId = "",
                        collectionName = "",
                        created = "",
                        id = "id2",
                        name = "Card 2",
                        photos = listOf(),
                        updated = "",
                        userRelation = ""
                    )
                ),
                1,
                2,
                2,
                1
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
        throw IOException()
    }
}
