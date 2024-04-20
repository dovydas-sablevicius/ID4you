package com.project.id4you.presentation.screens.createDocument

sealed class CreateDocumentEvent {
    data class EnteredName(val value: String) : CreateDocumentEvent()
    data class EnteredDocumentType(val value: String) : CreateDocumentEvent()
}
