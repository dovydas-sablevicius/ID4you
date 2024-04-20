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
    val validUntil: String,
    @SerializedName("expand")
    val expand: Expand?
)

data class Expand(
    @SerializedName("document_owner")
    val documentOwner: DocumentOwner
)

data class DocumentOwner(
    @SerializedName("birth_date")
    val birthDate: String,
    @SerializedName("collectionId")
    val collectionId: String,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("emailVisibility")
    val emailVisibility: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("personal_code")
    val personalCode: String,
    @SerializedName("surname")
    val surname: String,
    @SerializedName("updated")
    val updated: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("verified")
    val verified: Boolean
)

fun DocumentDto.toDocument(): Document {
    return Document(
        id = id,
        documentCode = documentCode,
        name = documentName,
        type = type,
        valid = valid,
        validUntil = validUntil,
        documentPhotos = documentPhotos,
        collectionId = collectionId,
        driverLicenseCategory = driverLicenseCategory,
        documentOwner = expand?.documentOwner
    )
}
