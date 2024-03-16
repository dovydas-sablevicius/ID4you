package com.project.id4you.data.remote

import com.project.id4you.data.remote.dto.UserDto
import com.project.id4you.data.remote.dto.UserLoginDto
import com.project.id4you.data.remote.dto.UserRegistrationDto
import retrofit2.http.Body
import retrofit2.http.POST

interface PocketBaseApi {
    @POST("/collections/users/records")
    suspend fun registerUser(@Body userRegistrationDto: UserRegistrationDto): Unit

    @POST("/collections/users/auth-with-password")
    suspend fun loginUser(@Body userLoginDto: UserLoginDto): UserDto

}
