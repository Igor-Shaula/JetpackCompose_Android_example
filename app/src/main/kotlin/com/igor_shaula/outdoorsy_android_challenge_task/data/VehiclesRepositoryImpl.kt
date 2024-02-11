package com.igor_shaula.outdoorsy_android_challenge_task.data

import com.igor_shaula.outdoorsy_android_challenge_task.data.network.NetworkDataSource
import com.igor_shaula.outdoorsy_android_challenge_task.data.network.OneVehicleData
import com.igor_shaula.outdoorsy_android_challenge_task.domain.VehiclesRepository

const val VALID_IMAGE_TYPE = "images"

class VehiclesRepositoryImpl : VehiclesRepository {

    private val dataSource = NetworkDataSource()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {

        val vehicleNetworkEntity = dataSource.launchSearchRequestFor(searchQuery)
        println("response: vehicleRawList = $vehicleNetworkEntity")

        val resultList = mutableListOf<OneVehicleData>()
        vehicleNetworkEntity.dataEntities.forEach {
            val imageType = it.relationships.primaryImage.imageData.imageType
            val imageIdFromDataEntity = it.relationships.primaryImage.imageData.imageId
            resultList.add(
                OneVehicleData(
                    imageId =
                    if (imageType == VALID_IMAGE_TYPE && imageIdFromDataEntity.isNotBlank()) {
                        imageIdFromDataEntity
                    } else "",
                    name = it.dataAttributesEntity.name
                )
            )
        }
        resultList.forEach { oneVehicleData ->
            vehicleNetworkEntity.includedEntities.forEach { includedEntity ->
                if (includedEntity.includedImageId == oneVehicleData.imageId) {
                    oneVehicleData.imageUrl = includedEntity.includedAttributesEntity.imageUrl
                }
            }
        }
        return resultList
    }
}
