package com.project.id4you.mocks.data.repository

import android.content.res.Resources.NotFoundException
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.document.DocumentDto
import com.project.id4you.data.remote.dto.document.DocumentsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto

class MockPocketBaseApi : PocketBaseApi {
    private val users = mutableListOf<UserDto>()
    private val cards = mutableListOf<DocumentsDto>()

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
            DocumentsDto(
                arrayListOf(
                    DocumentDto(
                        collectionId = "",
                        collectionName = "",
                        created = "",
                        id = "id1",
                        documentName = "Card 1",
                        documentPhotos = listOf(),
                        updated = "",
                        documentOwner = "",
                        valid = false,
                        type = "Passport",
                        passportCode = "417856164"
                    ),
                    DocumentDto(
                        collectionId = "",
                        collectionName = "",
                        created = "",
                        id = "id2",
                        documentName = "Card 2",
                        documentPhotos = listOf(),
                        updated = "",
                        documentOwner = "",
                        valid = false,
                        type = "ID Card",
                        passportCode = "15415489"
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


    override suspend fun getIdCards(authToken: String): DocumentsDto {
        return cards.firstOrNull()
            ?: throw NotFoundException()
    }
}
