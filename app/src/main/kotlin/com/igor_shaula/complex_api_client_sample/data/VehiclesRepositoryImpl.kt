package com.igor_shaula.complex_api_client_sample.data

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.data.network.NetworkGeneralFailure
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

const val VALID_IMAGE_TYPE = "images"

class VehiclesRepositoryImpl : VehiclesRepository {

    private val _errorData = MutableStateFlow(DataLayerGeneralFailure())
    override val errorData = _errorData.asStateFlow()

    private val dataSource = NetworkDataSource()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        val result = dataSource.launchSearchRequestFor(searchQuery)
        return if (result.isFailure) {
            val exception = result.exceptionOrNull() as NetworkGeneralFailure // by convention
            println("readVehiclesList: exception = $exception")
            _errorData.value = DataLayerGeneralFailure(exception.prepareExplanation())
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
