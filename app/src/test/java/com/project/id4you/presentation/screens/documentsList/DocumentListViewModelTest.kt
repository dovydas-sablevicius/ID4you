package com.project.id4you.presentation.screens.documentsList

import com.project.id4you.data.repository.model.IdCard
import com.project.id4you.domain.useCase.getIdCards.GetIdCardsUseCase
import com.project.id4you.mocks.data.repository.MockIdCardRepository
import com.project.id4you.presentation.singleton.AuthToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class DocumentListViewModelTest {

    private lateinit var documentsListViewModel: DocumentsListViewModel
    private lateinit var getIdCardsUseCase: GetIdCardsUseCase
    private lateinit var mockIdCardRepository: MockIdCardRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        mockIdCardRepository = MockIdCardRepository()
        getIdCardsUseCase = GetIdCardsUseCase(mockIdCardRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testDisplayDocumentList() {

        AuthToken.value = "Token"

        val idCards = listOf(
            IdCard("id1", "Card 1", "", ""),
            IdCard("id2", "Card 2", "", "")
        )
        
        documentsListViewModel = DocumentsListViewModel(getIdCardsUseCase)
        assert(documentsListViewModel.state.value.documents[0].name == idCards[0].name)
    }

    @Test
    fun testFailedDisplayDocumentList() {

        AuthToken.value = "asd"

        documentsListViewModel = DocumentsListViewModel(getIdCardsUseCase)
        assert(documentsListViewModel.state.value.error == "Wrong Data")
    }

}