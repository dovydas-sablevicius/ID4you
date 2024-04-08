package mocks

import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
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
            "1",
            "users",
            LocalDate.now().toString(),
            userRegistrationDto.email,
            false,
            java.util.UUID.randomUUID().toString(),
            LocalDate.now().toString(),
            java.util.UUID.randomUUID().toString(),
            false
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
            "1",
            "users",
            LocalDate.now().toString(),
            userLoginDto.identity,
            false,
            java.util.UUID.randomUUID().toString(),
            LocalDate.now().toString(),
            java.util.UUID.randomUUID().toString(),
            false
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

    override suspend fun getIdCards(authToken: String): IdCardsDto {
        return IdCardsDto(emptyList(), 1, 1, 1, 1)
    }

}