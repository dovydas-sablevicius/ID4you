package com.project.id4you.domain.repository

import com.project.id4you.common.Resource
import com.project.id4you.data.remote.dto.idCard.IdCardsDto
import kotlinx.coroutines.flow.Flow

interface IdCardRepository {
    suspend fun getIdCards(authToken: String): Flow<Resource<IdCardsDto>>
}