package com.igor_shaula.complex_api_client_sample.data_sources

import com.google.gson.Gson
import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import javax.inject.Inject

class FakeDataSource @Inject constructor(
    private val mockResponse: String
) {
    fun processMockResponse(): Result<VehicleNetworkEntity?> {
        val networkEntity = Gson().fromJson(mockResponse, VehicleNetworkEntity::class.java)
        return Result.success(networkEntity)
    }
}