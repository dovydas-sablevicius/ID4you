package com.project.id4you.mocks.data.repository

import android.content.res.Resources.NotFoundException
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardDto
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto

class MockPocketBaseApi : PocketBaseApi {
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
        val record = Record(
            "",
            "",
            "",
            userRegistrationDto.email,
            false,
            java.util.UUID.randomUUID().toString(),
            "",
            "",
            false
        )
        val userDto = UserDto(record, "")
        users.add(userDto)
    }

    override suspend fun loginUser(userLoginDto: UserLoginDto): UserDto {
        return users.find { userDto -> userDto.record.email == userLoginDto.identity }
            ?: throw NotFoundException()
    }


    override suspend fun getIdCards(authToken: String): IdCardsDto {
        return cards.firstOrNull()
            ?: throw NotFoundException()
    }
}
