package com.igor_shaula.complex_api_client_sample.domain

import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData

interface VehiclesRepository {

    suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData>
}
