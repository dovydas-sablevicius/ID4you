package com.project.id4you.mocks.data.repository

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardDto
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response

class MockPocketBaseApiHttpException : PocketBaseApi {
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
        throw HttpException(
            Response.error<Nothing>(
                500,
                "register http exception".toResponseBody()
            )
        )
    }

    override suspend fun loginUser(userLoginDto: UserLoginDto): UserDto {
        throw HttpException(
            Response.error<Nothing>(
                500,
                "login http exception".toResponseBody()
            )
        )
    }

    override suspend fun getIdCards(authToken: String): IdCardsDto {
        throw HttpException(
            Response.error<Nothing>(
                500,
                "id cards http exception".toResponseBody()
            )
        )
    }
}
