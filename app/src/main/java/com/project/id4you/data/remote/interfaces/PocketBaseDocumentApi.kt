package com.project.id4you.data.remote.interfaces

import com.project.id4you.data.remote.dto.document.DocumentDto
import com.project.id4you.data.remote.dto.document.DocumentsDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PocketBaseDocumentApi {
    @GET("/api/collections/document/records")
    suspend fun getDocuments(@Header("Authorization") authToken: String): DocumentsDto

    @GET("/api/collections/document/records/{id}")
    suspend fun getDocument(
        @Header("Authorization") authToken: String,
        @Path("id") id: String
    ): DocumentDto
}
