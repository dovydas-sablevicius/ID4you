package com.project.id4you.domain.useCase.getDocument

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDocumentUseCase @Inject constructor(
    private val repository: DocumentRepository
) {
    suspend operator fun invoke(authToken: String, id: String): Flow<Resource<Document>> {
        return repository.getDocument(authToken, id)
    }
}