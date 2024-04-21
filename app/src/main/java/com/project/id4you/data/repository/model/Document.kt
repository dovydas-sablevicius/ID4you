package com.project.id4you.data.repository.model

import com.project.id4you.data.remote.dto.document.DocumentOwner

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
    val documentOwner: DocumentOwner?,
)
