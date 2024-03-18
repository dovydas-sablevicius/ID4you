package com.project.id4you.data.remote.dto.idCard

data class IdCardsDto(
    val items: List<IdCardDto>,
    val page: Int,
    val perPage: Int,
    val totalItems: Int,
    val totalPages: Int
)