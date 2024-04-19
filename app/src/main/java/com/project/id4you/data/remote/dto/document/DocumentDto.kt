package com.project.id4you.data.remote.dto.document

import com.google.gson.annotations.SerializedName
import com.project.id4you.data.repository.model.Document

data class DocumentDto(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    @SerializedName("document_name")
    val documentName: String,
    @SerializedName("document_owner")
    val documentOwner: String,
    @SerializedName("document_photos")
    val documentPhotos: List<String>,
    val id: String,
    @SerializedName("document_code")
    val documentCode: String,
    val type: String,
    val updated: String,
    val valid: Boolean,
    @SerializedName("driver_license_category")
    val driverLicenseCategory: List<String>,
    @SerializedName("valid_from")
    val validFrom: String,
    @SerializedName("valid_until")
    val validUntil: String
)


fun DocumentDto.toDocument(): Document {
    return Document(
        id = id,
        documentCode = documentCode,
        name = documentName,
        type = type,
        valid = valid,
        validUntil = validUntil,
        documentPhotos = documentPhotos
    )
}
