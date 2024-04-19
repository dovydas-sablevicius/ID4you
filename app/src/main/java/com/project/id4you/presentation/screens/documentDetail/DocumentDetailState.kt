package com.project.id4you.presentation.screens.documentDetail

import com.project.id4you.data.repository.model.Document

data class DocumentDetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val document: Document? = null
)
