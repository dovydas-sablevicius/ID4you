package com.project.id4you.presentation.screens.documentQrScan

data class DocumentQrScanState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val documentId: String = "",
)
