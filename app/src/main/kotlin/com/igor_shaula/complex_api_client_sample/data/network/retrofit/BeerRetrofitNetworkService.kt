package com.igor_shaula.complex_api_client_sample.data.network.retrofit

import com.igor_shaula.complex_api_client_sample.data.entities.BeerNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.BEER_RESOURCE_PATH
import retrofit2.http.GET

// todo: add constants for all strings

interface BeerRetrofitNetworkService {

    @GET(BEER_RESOURCE_PATH)
    suspend fun getBeers(): List<BeerNetworkEntity>
}
