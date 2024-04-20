package com.project.id4you.mocks.data.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class MockDocumentRepository : DocumentRepository {
    override suspend fun getDocuments(authToken: String): Flow<Resource<List<Document>>> {

        val documents = listOf(
            Document(
                "id1",
                "Card 1",
                "",
                true,
                "415564",
                LocalDate.now().toString(),
                listOf(),
                "145154564",
                listOf()
            ),
            Document(
                "id2",
                "Card 2",
                "",
                true,
                "14556456456",
                LocalDate.now().toString(),
                listOf(),
                "564156456",
                listOf()
            )
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

    override suspend fun getDocument(authToken: String, id: String): Flow<Resource<Document>> {
        val documents = listOf(
            Document(
                "id1",
                "Card 1",
                "",
                true,
                "456456456456",
                LocalDate.now().toString(),
                listOf(),
                "564156456",
                listOf()
            ),
            Document(
                "id2",
                "Card 2",
                "",
                true,
                "456456456456",
                LocalDate.now().toString(),
                listOf(),
                "564156456",
                listOf()
            )
        )

        return flow {
            emit(Resource.Loading())
            if (authToken == "Token") {
                val document: Document =
                    documents.find { document: Document -> document.id == id }!!
                emit(Resource.Success(document))
            } else {
                emit(Resource.Error("Wrong Data"))
            }
        }
    }
}

