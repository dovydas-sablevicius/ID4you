package com.project.id4you.data.remote.dto.document

data class DocumentsDto(
    val items: List<DocumentDto>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)

