package com.project.id4you.presentation.screens.documentsList

import com.project.id4you.data.repository.model.Document
import org.junit.Test

class DocumentsListStateTest {

    @Test
    fun testDefaultDocumentsListState() {
        val defaultState = generateDefaultDocumentsListState()
        assert(!defaultState.isLoading)
        assert(defaultState.error == "")
        assert(defaultState.documents == emptyList<Document>())
    }

    @Test
    fun testLoadingDocumentsListState() {
        val loadingState = generateDocumentsListLoading()
        assert(loadingState.isLoading)
        assert(loadingState.error == "")
        assert(loadingState.documents == emptyList<Document>())
    }

    @Test
    fun testErrorDocumentListState() {
        val error: String = "Unexpected Error"
        val errorState = generateDocumentsListStateError(error)

        assert(!errorState.isLoading)
        assert(errorState.error == error)
        assert(errorState.documents == emptyList<Document>())

    }
}

fun generateDefaultDocumentsListState(): DocumentsListState {
    return DocumentsListState()
}

fun generateDocumentsListStateError(error: String): DocumentsListState {
    return DocumentsListState(error = error)
}

fun generateDocumentsListLoading(): DocumentsListState {
    return DocumentsListState(true)
}

