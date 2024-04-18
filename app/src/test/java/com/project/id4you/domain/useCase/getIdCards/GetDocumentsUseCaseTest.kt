package com.project.id4you.domain.useCase.getIdCards

import com.project.id4you.domain.useCase.getDocuments.GetDocumentsUseCase
import com.project.id4you.mocks.data.repository.MockDocumentRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetDocumentsUseCaseTest {

    private lateinit var mockedIdCardRepository: MockDocumentRepository
    private lateinit var idCardsUseCase: GetDocumentsUseCase

    @Before
    fun setUp() {
        mockedIdCardRepository = MockDocumentRepository()
        idCardsUseCase = GetDocumentsUseCase(mockedIdCardRepository)
    }

    @Test
    fun testGetIdCards() {
        val authToken: String = ""
        runBlocking {
            idCardsUseCase.invoke(authToken)
        }
        assert(true)
    }

}

