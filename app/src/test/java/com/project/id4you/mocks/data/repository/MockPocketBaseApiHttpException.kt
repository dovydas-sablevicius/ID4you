package com.project.id4you.mocks.data.repository

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.document.DocumentDto
import com.project.id4you.data.remote.dto.document.DocumentsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.time.LocalDate

class MockPocketBaseApiHttpException : PocketBaseApi {
    private val users = mutableListOf<UserDto>()
    private val cards = mutableListOf<DocumentsDto>()

    init {
        users.add(
            UserDto(
                Record(
                    id = "1",
                    email = "test@test.com",
                    username = java.util.UUID.randomUUID().toString(),
                    created = LocalDate.now().toString(),
                    updated = LocalDate.now().toString(),
                    birthDate = LocalDate.now().toString(),
                    collectionId = "1",
                    name = java.util.UUID.randomUUID().toString(),
                    surname = java.util.UUID.randomUUID().toString(),
                    verified = false,
                    collectionName = "users",
                    emailVisibility = false,
                    personalCode = java.util.UUID.randomUUID().toString()
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
                        documentCode = "4548494"
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
                        type = "Passport",
                        documentCode = "4548494"
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

    override suspend fun getDocuments(authToken: String): DocumentsDto {
        throw HttpException(
            Response.error<Nothing>(
                500,
                "id cards http exception".toResponseBody()
            )
        )
    }

    override suspend fun getDocument(authToken: String, id: String): DocumentDto {
        TODO("Not yet implemented")
    }
}
