package com.igor_shaula.complex_api_client_sample.fakes

import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.domain.GenericErrorForUI
import com.igor_shaula.complex_api_client_sample.domain.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.domain.assembleFromNetworkEntityOptimized
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeVehiclesRepository(
    private val fakeDataSource: FakeDataSource
) : VehiclesRepository {

    override val errorData = MutableStateFlow(GenericErrorForUI()).asStateFlow()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        val result = fakeDataSource.launchSearchRequestFor(searchQuery)
        return assembleFromNetworkEntityOptimized(result.getOrNull())
    }
}
