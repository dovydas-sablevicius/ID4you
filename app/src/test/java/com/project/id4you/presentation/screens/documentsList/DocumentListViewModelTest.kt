package com.project.id4you.presentation.screens.documentsList

import com.project.id4you.data.repository.model.Document
import com.project.id4you.domain.useCase.getDocuments.GetDocumentsUseCase
import com.project.id4you.mocks.data.repository.MockDocumentRepository
import com.project.id4you.presentation.singleton.AuthToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class DocumentListViewModelTest {

    private lateinit var documentsListViewModel: DocumentsListViewModel
    private lateinit var getDocumentsUseCase: GetDocumentsUseCase
    private lateinit var mockIdCardRepository: MockDocumentRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        mockIdCardRepository = MockDocumentRepository()
        getDocumentsUseCase = GetDocumentsUseCase(mockIdCardRepository)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testDisplayDocumentList() {

        AuthToken.value = "Token"

        val documents = listOf(
            Document(
                "id1",
                "Card 1",
                "",
                true,
                "456456456456",
                LocalDate.now().toString(),
                listOf(),
                "564156456",
                listOf(),
                null
            ),
            Document(
                "id2",
                "Card 2",
                "",
                true,
                "456456456456",
                LocalDate.now().toString(),
                listOf(),
                "564156456",
                listOf(),
                null
            )
        )

        documentsListViewModel = DocumentsListViewModel(getDocumentsUseCase)
        assert(documentsListViewModel.state.value.documents[0].name == documents[0].name)
    }

    @Test
    fun testFailedDisplayDocumentList() {

        AuthToken.value = "asd"

        documentsListViewModel = DocumentsListViewModel(getDocumentsUseCase)
        assert(documentsListViewModel.state.value.error == "Wrong Data")
    }

}

