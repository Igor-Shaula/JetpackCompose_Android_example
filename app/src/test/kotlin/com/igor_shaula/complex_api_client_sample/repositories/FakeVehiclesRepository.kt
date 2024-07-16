package com.igor_shaula.complex_api_client_sample.repositories

import com.igor_shaula.complex_api_client_sample.data.GenericErrorForUI
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.data.repositories.VehiclesRepository
import com.igor_shaula.complex_api_client_sample.data.repositories.assembleFromNetworkEntityOptimized
import com.igor_shaula.complex_api_client_sample.data_sources.FakeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeVehiclesRepository(
    private val fakeDataSource: FakeDataSource? = null
) : VehiclesRepository {

    var errorDataForTest = MutableStateFlow(GenericErrorForUI())
    override val errorData = errorDataForTest.asStateFlow()

    override suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData> {
        println("launchSearchRequestFor: searchQuery = \"$searchQuery\"")
        val result = fakeDataSource?.processMockResponse()
//        println("launchSearchRequestFor: result: \"$result\"")
        return assembleFromNetworkEntityOptimized(result?.getOrNull())
    }
}