package com.project.id4you.data.repository.impl

import com.project.id4you.common.Resource
import com.project.id4you.data.repository.model.IdCard
import com.project.id4you.mocks.data.repository.MockPocketBaseApi
import com.project.id4you.mocks.data.repository.MockPocketBaseApiHttpException
import com.project.id4you.mocks.data.repository.MockPocketBaseApiIOException
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Test

class IdCardRepositoryImplTest {

    private lateinit var idCardRepositoryImpl: IdCardRepositoryImpl

    @Test
    fun getIdCard() {
        val pocketBaseApi = MockPocketBaseApi()
        val idCardRepositoryImpl = IdCardRepositoryImpl(pocketBaseApi)

        val authToken: String = ""
        val name: String = "Card 2"

        val response: List<Resource<List<IdCard>>>
        runBlocking {
            response = idCardRepositoryImpl.getIdCards(authToken).toList()
        }
        assert(response.first()::class == Resource.Loading<IdCard>()::class)
        assert(response[1].data!![1].name == name)
    }

    @Test
    fun testDocumentListHttpExceptions() {
        val pocketBaseApi = MockPocketBaseApiHttpException()
        idCardRepositoryImpl = IdCardRepositoryImpl(pocketBaseApi)

        val authToken: String = ""

        val response: List<Resource<List<IdCard>>>
        runBlocking {
            response = idCardRepositoryImpl.getIdCards(authToken).toList()
        }
        assert(response.first()::class == Resource.Loading<IdCard>()::class)
        assert(response[1]::class == Resource.Error<IdCard>("HTTP 500 Response.error()")::class)
        assert(response[1].message == "HTTP 500 Response.error()")
    }

    @Test
    fun testDocumentListIOException() {
        val pocketBaseApi = MockPocketBaseApiIOException()
        idCardRepositoryImpl = IdCardRepositoryImpl(pocketBaseApi)

        val authToken: String = ""

        val response: List<Resource<List<IdCard>>>
        runBlocking {
            response = idCardRepositoryImpl.getIdCards(authToken).toList()
        }
        assert(response.first()::class == Resource.Loading<IdCard>()::class)
        assert(response[1]::class == Resource.Error<IdCard>("Couldn't reach server.")::class)
        assert(response[1].message == "Couldn't reach server.")
    }

}
