package com.project.id4you.data.repository.Impl

import com.project.id4you.common.ExceptionMessages
import com.project.id4you.common.Resource
import com.project.id4you.data.remote.PocketBaseApi
import com.project.id4you.data.remote.dto.idCard.toIdCard
import com.project.id4you.data.repository.model.IdCard
import com.project.id4you.domain.repository.IdCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class IdCardRepositoryImpl @Inject constructor(
    private val api: PocketBaseApi
) : IdCardRepository {
    override suspend fun getIdCards(authToken: String): Flow<Resource<List<IdCard>>> = flow {
        try {
            emit(Resource.Loading())
            val idCards: List<IdCard> = api.getIdCards(authToken).items.map { it.toIdCard() }
            emit(Resource.Success(idCards))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.httpExceptionMessage))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ExceptionMessages.ioExceptionMessage))
        }
    }

}