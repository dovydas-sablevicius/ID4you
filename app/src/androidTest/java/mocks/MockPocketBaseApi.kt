package mocks

import android.content.res.Resources.NotFoundException
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import com.project.id4you.data.remote.dto.user.Record
import com.project.id4you.data.remote.dto.user.UserDto
import com.project.id4you.data.remote.dto.user.UserLoginDto
import com.project.id4you.data.remote.dto.user.UserRegistrationDto
import java.time.LocalDate

class MockPocketBaseApi : PocketBaseApi {
    private val state = mutableListOf<UserDto>()
    override suspend fun registerUser(userRegistrationDto: UserRegistrationDto) {
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
        return state.find { userDto -> userDto.record.email == userLoginDto.identity }
            ?: throw NotFoundException()
    }

    override suspend fun getIdCards(authToken: String): IdCardsDto {
        TODO("Not yet implemented")
    }

}