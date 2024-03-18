package com.project.id4you.data.remote.interfaces

import com.project.id4you.data.remote.dto.UserDto
import com.project.id4you.data.remote.dto.UserLoginDto
import com.project.id4you.data.remote.dto.UserRegistrationDto
import retrofit2.http.Body
import retrofit2.http.POST

interface PocketBaseUserApi {
    @POST("api/collections/users/records")
    suspend fun registerUser(@Body userRegistrationDto: UserRegistrationDto)

    @POST("api/collections/users/auth-with-password")
    suspend fun loginUser(@Body userLoginDto: UserLoginDto): UserDto
}