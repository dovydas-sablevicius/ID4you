package com.project.id4you.presentation.screens.documentsList

import com.project.id4you.data.repository.model.Document

data class DocumentsListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val documents: List<Document> = emptyList()
)
