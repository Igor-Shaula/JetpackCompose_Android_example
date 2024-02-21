package com.igor_shaula.complex_api_client_sample.data

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository

const val VALID_IMAGE_TYPE = "images"

class VehiclesRepositoryImpl : VehiclesRepository {

    private val dataSource = NetworkDataSource()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        val result = dataSource.launchSearchRequestFor(searchQuery)
        return if (result.isFailure) {
            val exception = result.exceptionOrNull()
            println("readVehiclesList: exception = $exception")
            // TODO: propagate error state for UI layer here
            emptyList()
        } else {
            assembleFromNetworkEntity(result.getOrNull()) // in fact there will not ever be null here
        }
    }

    private fun assembleFromNetworkEntity(networkEntity: VehicleNetworkEntity?): List<OneVehicleData> {
        println("response: vehicleRawList = $networkEntity")
        val resultList = mutableListOf<OneVehicleData>()
        networkEntity?.dataEntities?.forEach {
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
            networkEntity?.includedEntities?.forEach { includedEntity ->
                if (includedEntity.includedImageId == oneVehicleData.imageId) {
                    oneVehicleData.imageUrl = includedEntity.includedAttributesEntity.imageUrl
                }
            }
        }
        return resultList
    }
}
