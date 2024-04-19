package com.project.id4you.data.remote.dto.user

import com.google.gson.annotations.SerializedName
import com.project.id4you.data.repository.model.User

data class UserDto(
    val record: Record,
    val token: String
)

data class Record(
    @SerializedName("birth_date")
    val birthDate: String,
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val email: String,
    val emailVisibility: Boolean,
    val id: String,
    val name: String,
    @SerializedName("personal_code")
    val personalCode: String,
    val surname: String,
    val updated: String,
    val username: String,
    val verified: Boolean
)

fun UserDto.toUser(): User {
    return User(
        token = token,
        id = record.id,
        email = record.email,
        username = record.username,
    )
}
