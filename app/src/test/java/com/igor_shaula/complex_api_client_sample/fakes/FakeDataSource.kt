package com.igor_shaula.complex_api_client_sample.fakes

import com.google.gson.Gson
import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import javax.inject.Inject

class FakeDataSource @Inject constructor(
    private val mockResponse: String
) {
    fun launchSearchRequestFor(searchQuery: String): Result<VehicleNetworkEntity?> {
        println("launchSearchRequestFor in FakeDataSource: searchQuery = $searchQuery")
        val networkEntity = Gson().fromJson(mockResponse, VehicleNetworkEntity::class.java)
        return Result.success(networkEntity)
    }
}