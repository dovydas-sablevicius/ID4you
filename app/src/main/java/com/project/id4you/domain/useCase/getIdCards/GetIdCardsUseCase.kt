package com.project.id4you.domain.useCase.getIdCards

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.IdCard
import com.project.id4you.domain.repository.IdCardRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetIdCardsUseCase @Inject constructor(
    private val repository: IdCardRepository
) {
    suspend operator fun invoke(authToken: String): Flow<Resource<List<IdCard>>> {
        return repository.getIdCards(authToken)
    }
}
