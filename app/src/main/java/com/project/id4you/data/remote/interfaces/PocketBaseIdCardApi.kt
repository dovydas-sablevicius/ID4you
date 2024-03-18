package com.project.id4you.data.remote.interfaces

import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import retrofit2.http.GET
import retrofit2.http.Header

interface PocketBaseIdCardApi {
    @GET("/api/collections/id_card/records")
    suspend fun getIdCards(@Header("Authorization") authToken: String): IdCardsDto
}