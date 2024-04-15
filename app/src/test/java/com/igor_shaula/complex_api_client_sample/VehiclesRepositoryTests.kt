package com.igor_shaula.complex_api_client_sample

import com.igor_shaula.complex_api_client_sample.data.VehiclesRepositoryImpl
import com.igor_shaula.complex_api_client_sample.data.assembleFromNetworkEntityOptimized
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.fakes.FakeNetworkApiService
import com.igor_shaula.complex_api_client_sample.fakes.fakeVehicleNetworkEntityWithEmptyData
import com.igor_shaula.complex_api_client_sample.fakes.fakeVehicleNetworkEntityWithFullData
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class VehiclesRepositoryTests {

    @Test
    fun launchSearchRequestFor_verifyVehiclesListWithFilledList() = runTest {
        val fakeNetworkApiService = FakeNetworkApiService(fakeVehicleNetworkEntityWithFullData)
        val fakeNetworkDataSource = NetworkDataSource(fakeNetworkApiService)
        val repository = VehiclesRepositoryImpl(fakeNetworkDataSource)
        Assert.assertEquals(
            assembleFromNetworkEntityOptimized(fakeVehicleNetworkEntityWithFullData),
            repository.launchSearchRequestFor("goodRequest")
        )
    }

    @Test
    fun launchSearchRequestFor_verifyVehiclesListWithEmptyList() = runTest {
        val fakeNetworkApiService = FakeNetworkApiService(fakeVehicleNetworkEntityWithEmptyData)
        val fakeNetworkDataSource = NetworkDataSource(fakeNetworkApiService)
        val repository = VehiclesRepositoryImpl(fakeNetworkDataSource)
        Assert.assertEquals(
            emptyList<OneVehicleData>(),
            repository.launchSearchRequestFor("noDataRequest")
        )
    }
}
