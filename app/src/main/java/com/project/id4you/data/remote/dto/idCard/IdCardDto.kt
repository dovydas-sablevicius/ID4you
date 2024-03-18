package com.project.id4you.data.remote.dto.idCard

data class IdCardDto(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val id: String,
    val name: String,
    val photos: List<String>,
    val updated: String,
    val user_relation: String
)