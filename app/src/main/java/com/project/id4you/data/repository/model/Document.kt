package com.project.id4you.data.repository.model

data class Document(
    val id: String,
    val name: String,
    val type: String,
    val valid: Boolean,
    val documentCode: String,
    val validUntil: String,
    val documentPhotos: List<String>,
    val collectionId: String,
    val driverLicenseCategory: List<String>,
)
