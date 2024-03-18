package com.project.id4you.data.remote.dto.idCard

import com.google.gson.annotations.SerializedName
import com.project.id4you.data.repository.model.IdCard

data class IdCardDto(
    val collectionId: String,
    val collectionName: String,
    val created: String,
    val id: String,
    val name: String,
    val photos: List<String>,
    val updated: String,
    @SerializedName("user_relation")
    val userRelation: String
)

fun IdCardDto.toIdCard(): IdCard {
    return IdCard(
        id = id,
        name = name,
        updated = updated,
        created = created
    )
}
