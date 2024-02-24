package com.igor_shaula.complex_api_client_sample.domain

import com.igor_shaula.complex_api_client_sample.data.DataLayerGeneralFailure
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import kotlinx.coroutines.flow.Flow

interface VehiclesRepository {

    val errorData: Flow<DataLayerGeneralFailure>

    suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData>
}
