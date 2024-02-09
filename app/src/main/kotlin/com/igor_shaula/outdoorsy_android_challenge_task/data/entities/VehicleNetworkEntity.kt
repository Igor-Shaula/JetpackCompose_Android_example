package com.igor_shaula.outdoorsy_android_challenge_task.data.entities

import com.google.gson.annotations.SerializedName

data class VehicleNetworkEntity(
    @SerializedName("data") val dataEntities: List<DataEntity>,
    @SerializedName("included") val includedEntities: List<IncludedEntity>
)

data class DataEntity(
    @SerializedName("attributes") val dataAttributesEntity: DataAttributesEntity,
    @SerializedName("relationships") val relationships: RelationshipsEntity
)

data class DataAttributesEntity(
    @SerializedName("name") val name: String
)

data class RelationshipsEntity(
    @SerializedName("primary_image") val primaryImage: PrimaryImage
)

data class PrimaryImage(
    @SerializedName("data") val imageData: PrimaryImageData
)

data class PrimaryImageData(
    @SerializedName("id") val imageId: Int,
    @SerializedName("type") val imageType: String // it has "images" but it's present in the requirement
)

data class IncludedEntity(
    @SerializedName("attributes") val includedAttributesEntity: IncludedAttributesEntity
)

data class IncludedAttributesEntity(
    @SerializedName("url") val imageUrl: String
)
