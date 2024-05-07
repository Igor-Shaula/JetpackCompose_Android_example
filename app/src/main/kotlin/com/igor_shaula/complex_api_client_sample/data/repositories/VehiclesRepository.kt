package com.igor_shaula.complex_api_client_sample.data.repositories

import com.igor_shaula.complex_api_client_sample.data.GenericErrorForUI
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import kotlinx.coroutines.flow.Flow

interface VehiclesRepository {

    val errorData: Flow<GenericErrorForUI>

    suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData>
}
