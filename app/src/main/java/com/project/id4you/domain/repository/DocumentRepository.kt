package com.project.id4you.domain.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.Document
import kotlinx.coroutines.flow.Flow

interface DocumentRepository {
    suspend fun getDocuments(authToken: String): Flow<Resource<List<Document>>>
    suspend fun getDocument(authToken: String, id: String): Flow<Resource<Document>>
}
