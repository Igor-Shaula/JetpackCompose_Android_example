package com.igor_shaula.complex_api_client_sample

import com.igor_shaula.complex_api_client_sample.data.VehiclesRepositoryImpl
import com.igor_shaula.complex_api_client_sample.data.assembleFromNetworkEntityOptimized
import com.igor_shaula.complex_api_client_sample.data.network.NetworkDataSource
import com.igor_shaula.complex_api_client_sample.fakes.FakeNetworkApiService
import com.igor_shaula.complex_api_client_sample.fakes.fakeVehicleNetworkEntity
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class VehiclesRepositoryTests {

    @Test
    fun vehiclesRepositoryImpl_launchSearchRequestFor_verifyVehiclesList() = runTest {
        val fakeNetworkApiService = FakeNetworkApiService()
        val fakeNetworkDataSource = NetworkDataSource(fakeNetworkApiService)
        val repository = VehiclesRepositoryImpl(fakeNetworkDataSource)
        Assert.assertEquals(
            assembleFromNetworkEntityOptimized(fakeVehicleNetworkEntity),
            repository.launchSearchRequestFor("goodRequest")
        )
    }
}
