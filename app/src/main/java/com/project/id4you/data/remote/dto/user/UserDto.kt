package com.project.id4you.data.remote.dto.user

import com.project.id4you.data.repository.model.User

data class UserDto(
    val record: Record,
    val token: String
)

data class Record(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val email: String,
    val emailVisibility: Boolean,
    val id: String,
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
