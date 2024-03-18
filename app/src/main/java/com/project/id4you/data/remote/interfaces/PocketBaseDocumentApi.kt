package com.project.id4you.data.remote.interfaces

import retrofit2.http.GET
import retrofit2.http.Header

interface PocketBaseDocumentApi {
    @GET("/api/collections/id_card/records")
    suspend fun getDocuments(@Header("Authorization") authToken: String)
}