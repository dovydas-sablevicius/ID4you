package com.project.id4you.mocks.data.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.IdCard
import com.project.id4you.domain.repository.IdCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockIdCardRepository : IdCardRepository {
    override suspend fun getIdCards(authToken: String): Flow<Resource<List<IdCard>>> {

        val idCards = listOf(
            IdCard("id1", "Card 1", "", ""),
            IdCard("id2", "Card 2", "", "")
        )

        return flow {
            emit(Resource.Loading())
            if (authToken == "Token") {
                emit(Resource.Success(idCards))
            } else {
                emit(Resource.Error("Wrong Data"))
            }
        }
    }
}

