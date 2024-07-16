package com.igor_shaula.complex_api_client_sample.fakes

import com.igor_shaula.complex_api_client_sample.data_sources.FakeDataSource

val fakeVehicleNetworkEntityWithFullData =
    FakeDataSource(mockResponseWithFullData).processMockResponse().getOrNull()

val fakeVehicleNetworkEntityWithEmptyData =
    FakeDataSource(mockResponseWithEmptyData).processMockResponse().getOrNull()
