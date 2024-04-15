package com.igor_shaula.complex_api_client_sample.fakes

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Response

class FakeNetworkApiService : VehicleRetrofitNetworkService {

    // these arguments are required by the interface and do not matter here as we use fakeVehicleNetworkEntity
    override suspend fun getVehiclesList(
        searchQuery: String, pageLimit: Int, pageOffset: Int
    ): Response<VehicleNetworkEntity> = Response.success(fakeVehicleNetworkEntity)
}

val fakeVehicleNetworkEntity =
    FakeDataSource(mockResponseWithFullData).processMockResponse().getOrNull()