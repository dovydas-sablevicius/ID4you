package com.project.id4you.domain.useCase.getIdCards

import com.project.id4you.mocks.data.repository.MockIdCardRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetIdCardsUseCaseTest {

    private lateinit var mockedIdCardRepository: MockIdCardRepository
    private lateinit var idCardsUseCase: GetIdCardsUseCase

    @Before
    fun setUp() {
        mockedIdCardRepository = MockIdCardRepository()
        idCardsUseCase = GetIdCardsUseCase(mockedIdCardRepository)
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

