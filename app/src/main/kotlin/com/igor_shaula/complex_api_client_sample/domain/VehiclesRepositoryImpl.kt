package com.igor_shaula.complex_api_client_sample.domain

import com.igor_shaula.complex_api_client_sample.data.DataLayerGeneralFailure
import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.data.network.NetworkGeneralFailure
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.data.prepareExplanation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

const val VALID_IMAGE_TYPE = "images"

class VehiclesRepositoryImpl : VehiclesRepository {

    private val _errorData = MutableStateFlow(DataLayerGeneralFailure())
    override val errorData = _errorData.asStateFlow()

    private val dataSource = NetworkDataSource()
//    private val dataSource = FakeDataSource() // also works and is ready for checking API

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        val result = dataSource.launchSearchRequestFor(searchQuery)
        return if (result.isFailure) {
            val exception = result.exceptionOrNull() as NetworkGeneralFailure // by convention
            println("readVehiclesList: exception = $exception")
            _errorData.value = DataLayerGeneralFailure(exception.prepareExplanation())
            emptyList()
        } else {
            assembleFromNetworkEntityOptimized(result.getOrNull()) // in fact there will not ever be null here
        }
    }

    @Suppress("unused")
    private fun assembleFromNetworkEntity3Loops(networkEntity: VehicleNetworkEntity?): List<OneVehicleData> {
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

private fun assembleFromNetworkEntityOptimized(networkEntity: VehicleNetworkEntity?): List<OneVehicleData> {
    println("response: vehicleRawList = $networkEntity")
    val resultList = mutableListOf<OneVehicleData>()

    val dataEntitiesFlow = networkEntity?.dataEntities?.asFlow() // not a list but flow of instances
    val includedEntitiesFlow = flowOf(networkEntity?.includedEntities) // non-nullable flow of lists

    runBlocking {
        // just to save memory on instances creation while working inside the following flow
        var imageType: String
        var imageIdFromDataEntity: String

        // every dataEntity has to work with the same includedEntity - this is why we use COMBINE
        dataEntitiesFlow?.combine(includedEntitiesFlow) { dataEntity, includedEntityList ->

            imageType = dataEntity.relationships.primaryImage.imageData.imageType
            imageIdFromDataEntity = dataEntity.relationships.primaryImage.imageData.imageId

            resultList.add(
                OneVehicleData(
                    imageId = if (imageType == VALID_IMAGE_TYPE && imageIdFromDataEntity.isNotBlank()) {
                        imageIdFromDataEntity
                    } else "",
                    name = dataEntity.dataAttributesEntity.name,
                    imageUrl = includedEntityList
                        ?.first { includedEntity -> includedEntity.includedImageId == imageIdFromDataEntity }
                        ?.includedAttributesEntity?.imageUrl
                        ?: ""
                )
            )
        }?.collect() // just to launch all of that
    }
    return resultList
}
