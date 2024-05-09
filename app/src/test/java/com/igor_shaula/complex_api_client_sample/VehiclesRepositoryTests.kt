package com.igor_shaula.complex_api_client_sample

import com.igor_shaula.complex_api_client_sample.data.repositories.VehiclesRepositoryImpl
import com.igor_shaula.complex_api_client_sample.data.repositories.assembleFromNetworkEntity3Loops
import com.igor_shaula.complex_api_client_sample.data.repositories.assembleFromNetworkEntityOptimized
import com.igor_shaula.complex_api_client_sample.data.network.NetworkVehicleDataSource
import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData
import com.igor_shaula.complex_api_client_sample.fakes.FakeNetworkApiService
import com.igor_shaula.complex_api_client_sample.fakes.fakeVehicleNetworkEntityWithEmptyData
import com.igor_shaula.complex_api_client_sample.fakes.fakeVehicleNetworkEntityWithFullData
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class VehiclesRepositoryTests {

    @Test
    fun launchSearchRequestFor_verifyFilledVehiclesList() = runTest {
        val fakeNetworkApiServiceWithFullData =
            FakeNetworkApiService(fakeVehicleNetworkEntityWithFullData, shouldBeError = false)
        val fakeNetworkVehicleDataSource = NetworkVehicleDataSource(fakeNetworkApiServiceWithFullData)
        val repository = VehiclesRepositoryImpl(fakeNetworkVehicleDataSource)
        Assert.assertEquals(
            assembleFromNetworkEntityOptimized(fakeVehicleNetworkEntityWithFullData),
            repository.launchSearchRequestFor("goodRequest")
        )
    }

    @Test
    fun launchSearchRequestFor_verifyEmptyVehiclesList() = runTest {
        val fakeNetworkApiServiceWithEmptyData =
            FakeNetworkApiService(fakeVehicleNetworkEntityWithEmptyData, shouldBeError = false)
        val fakeNetworkVehicleDataSource = NetworkVehicleDataSource(fakeNetworkApiServiceWithEmptyData)
        val repository = VehiclesRepositoryImpl(fakeNetworkVehicleDataSource)
        Assert.assertEquals(
            emptyList<OneVehicleData>(),
            repository.launchSearchRequestFor("noDataRequest")
        )
    }

    @Test
    fun vehiclesRepositoryImpl_newFlowBasedSolutionResultEqualsOlderLoopsBasedSolutionResult() =
        runTest {
            Assert.assertEquals(
                assembleFromNetworkEntity3Loops(fakeVehicleNetworkEntityWithFullData),
                assembleFromNetworkEntityOptimized(fakeVehicleNetworkEntityWithFullData)
            )
            Assert.assertEquals(
                assembleFromNetworkEntity3Loops(fakeVehicleNetworkEntityWithEmptyData),
                assembleFromNetworkEntityOptimized(fakeVehicleNetworkEntityWithEmptyData)
            )
        }

    @Test
    fun launchSearchRequestFor_verifyEmptyVehiclesListFromErrorResult() = runTest {
        val fakeNetworkApiServiceWithEmptyData = FakeNetworkApiService(shouldBeError = true)
        val fakeNetworkVehicleDataSource = NetworkVehicleDataSource(fakeNetworkApiServiceWithEmptyData)
        val repository = VehiclesRepositoryImpl(fakeNetworkVehicleDataSource)
        Assert.assertEquals(
            emptyList<OneVehicleData>(),
            repository.launchSearchRequestFor("failedRequest")
        )
//        Assert.assertEquals(
//            42, repository.errorData.value
//        )
    }
}
