package com.project.id4you.domain.useCase.getDocuments

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.repository.DocumentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDocumentsUseCase @Inject constructor(
    private val repository: DocumentRepository
) {
    suspend operator fun invoke(authToken: String): Flow<Resource<List<Document>>> {
        return repository.getDocuments(authToken)
    }
}
