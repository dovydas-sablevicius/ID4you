package com.project.id4you.mocks.data.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockDocumentRepository : DocumentRepository {
    override suspend fun getDocuments(authToken: String): Flow<Resource<List<Document>>> {

        val documents = listOf(
            Document("id1", "Card 1", "", ""),
            Document("id2", "Card 2", "", "")
        )

        return flow {
            emit(Resource.Loading())
            if (authToken == "Token") {
                emit(Resource.Success(documents))
            } else {
                emit(Resource.Error("Wrong Data"))
            }
        }
    }
}

