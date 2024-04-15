package com.igor_shaula.complex_api_client_sample.fakes

val fakeVehicleNetworkEntityWithFullData =
    FakeDataSource(mockResponseWithFullData).processMockResponse().getOrNull()

val fakeVehicleNetworkEntityWithEmptyData =
    FakeDataSource(mockResponseWithEmptyData).processMockResponse().getOrNull()
