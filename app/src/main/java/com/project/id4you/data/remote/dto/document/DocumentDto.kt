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
    @SerializedName("passport_code")
    val passportCode: String,
    val type: String,
    val updated: String,
    val valid: Boolean
)


fun DocumentDto.toDocument(): Document {
    return Document(
        id = id,
        name = documentName,
        updated = updated,
        created = created
    )
}
