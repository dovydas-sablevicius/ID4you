package mocks

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.document.DocumentDto
import com.project.id4you.data.remote.dto.document.DocumentsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import kotlinx.coroutines.delay
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.time.LocalDate

class MockPocketBaseApi : PocketBaseApi {
    private val state = mutableListOf<UserDto>()
    override suspend fun registerUser(userRegistrationDto: UserRegistrationDto) {

        if (userRegistrationDto.email == "" || userRegistrationDto.password == "") {
            throw HttpException(
                Response.error<Nothing>(
                    500,
                    "login http exception".toResponseBody()
                )
            )
        }

        delay(1000L)
        val record = Record(
            id = "1",
            email = userRegistrationDto.email,
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
        )
        val user = UserDto(record, "")
        state.add(user)
    }

    override suspend fun loginUser(userLoginDto: UserLoginDto): UserDto {
        if (userLoginDto.identity == "") {
            throw HttpException(
                Response.error<Nothing>(
                    500,
                    "login http exception".toResponseBody()
                )
            )
        }
        val record = Record(
            id = "1",
            email = userLoginDto.identity,
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
        )
        val user = UserDto(record, "token")
        state.add(user)
        delay(1000L)
        return state.find { userDto -> userDto.record.email == userLoginDto.identity }
            ?: throw HttpException(
                Response.error<Nothing>(
                    500,
                    "login http exception".toResponseBody()
                )
            )
    }

    override suspend fun getDocuments(authToken: String): DocumentsDto {
        val idCards = listOf(
            DocumentDto(
                collectionId = "1",
                collectionName = "Collection 1",
                created = "2022-04-05",
                id = "1",
                documentName = "Card 1",
                documentPhotos = listOf(
                    "https://example.com/photo1.jpg",
                    "https://example.com/photo2.jpg"
                ),
                updated = "2022-04-05",
                documentOwner = "user",
                passportCode = "4145656460",
                type = "Passport",
                valid = false
            )
        )
        return DocumentsDto(idCards, 1, 1, 1, 1)
    }

}