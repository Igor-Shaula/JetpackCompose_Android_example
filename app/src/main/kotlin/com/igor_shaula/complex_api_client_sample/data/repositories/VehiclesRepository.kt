package com.igor_shaula.complex_api_client_sample.data.repositories

import androidx.annotation.VisibleForTesting
import com.igor_shaula.complex_api_client_sample.data.GenericErrorForUI
import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.data.network.NetworkGeneralFailure
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

interface VehiclesRepository {

    val errorData: Flow<GenericErrorForUI>

    suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData>
}

const val VALID_IMAGE_TYPE = "images"

class VehiclesRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : VehiclesRepository {

    private val _errorData = MutableStateFlow(GenericErrorForUI())
    override val errorData = _errorData.asStateFlow()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        val entityResult = networkDataSource.launchSearchRequestFor(searchQuery)
        return convertIntoListOfData(entityResult)
    }

    // be careful as this function contains side-effect with modification of "_errorData.value"
    private fun convertIntoListOfData(entityResult: Result<VehicleNetworkEntity?>): List<OneVehicleData> =
        if (entityResult.isFailure) {
            val exception = entityResult.exceptionOrNull() as NetworkGeneralFailure
            println("readVehiclesList: exception = $exception")
            _errorData.value = GenericErrorForUI(exception.prepareExplanation())
            emptyList()
        } else {
            _errorData.value = GenericErrorForUI() // in fact this works to remove the error state
            assembleFromNetworkEntityOptimized(
                entityResult.getOrNull()
            ) // in fact there will not ever be null here
        }
}

// previous approach - not optimized & not used any more - let it stay here for comparison
@VisibleForTesting
internal fun assembleFromNetworkEntity3Loops(networkEntity: VehicleNetworkEntity?): List<OneVehicleData> {
//    println("response: vehicleRawList = $networkEntity")
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

@VisibleForTesting
internal fun assembleFromNetworkEntityOptimized(networkEntity: VehicleNetworkEntity?): List<OneVehicleData> {
//    println("response: vehicleRawList = $networkEntity")
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
