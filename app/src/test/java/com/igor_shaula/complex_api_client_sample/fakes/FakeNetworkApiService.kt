package com.igor_shaula.complex_api_client_sample.fakes

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Response

class FakeNetworkApiService(
    private val vehicleNetworkEntity: VehicleNetworkEntity? = null,
    private val shouldBeError: Boolean
) : VehicleRetrofitNetworkService {

    override suspend fun getVehiclesList(
        searchQuery: String, pageLimit: Int, pageOffset: Int
        // these arguments are required by the interface and do not matter here as we use fakeVehicleNetworkEntity
    ): Response<VehicleNetworkEntity> = if (shouldBeError) {
        Response.error(42, null) // todo: remake this to use Result.failure() somehow
    } else {
        Response.success(vehicleNetworkEntity)
    }
}
