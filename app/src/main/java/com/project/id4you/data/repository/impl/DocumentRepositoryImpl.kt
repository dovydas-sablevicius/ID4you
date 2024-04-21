package com.project.id4you.data.repository.impl

import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.document.toDocument
import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DocumentRepositoryImpl @Inject constructor(
    private val api: PocketBaseApi
) : DocumentRepository {
    override suspend fun getDocuments(authToken: String): Flow<Resource<List<Document>>> = flow {
        try {
            emit(Resource.Loading())
            val documents: List<Document> =
                api.getDocuments(authToken).items.map { it.toDocument() }
            emit(Resource.Success(documents))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.httpExceptionMessage))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.ioExceptionMessage))
        }
    }

    override suspend fun getDocument(authToken: String, id: String): Flow<Resource<Document>> =
        flow {
            try {
                emit(Resource.Loading())
                val document: Document = api.getDocument(authToken, id).toDocument()
                emit(Resource.Success(document))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.httpExceptionMessage))
            } catch (e: IOException) {
                emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.ioExceptionMessage))
            }
        }

}
