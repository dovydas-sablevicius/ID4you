package com.project.id4you.presentation.screens.documentDetail

data class DocumentDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val documentId: String = ""
)
