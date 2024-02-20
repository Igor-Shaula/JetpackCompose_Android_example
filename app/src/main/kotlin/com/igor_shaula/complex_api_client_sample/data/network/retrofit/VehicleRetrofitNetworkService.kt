package com.igor_shaula.complex_api_client_sample.data.network.retrofit

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.FILTER_KEYWORDS_QUERY
import com.igor_shaula.complex_api_client_sample.data.network.PAGE_LIMIT_QUERY
import com.igor_shaula.complex_api_client_sample.data.network.PAGE_LIMIT_VALUE
import com.igor_shaula.complex_api_client_sample.data.network.PAGE_OFFSET_QUERY
import com.igor_shaula.complex_api_client_sample.data.network.PAGE_OFFSET_VALUE
import com.igor_shaula.complex_api_client_sample.data.network.RESOURCE_PATH
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleRetrofitNetworkService {

    @GET(RESOURCE_PATH)
    suspend fun getVehiclesList(
        @Query(FILTER_KEYWORDS_QUERY) searchQuery: String,
        @Query(PAGE_LIMIT_QUERY) pageLimit: Int = PAGE_LIMIT_VALUE, // paging will be configured later
        @Query(PAGE_OFFSET_QUERY) pageOffset: Int = PAGE_OFFSET_VALUE // paging will be configured later
    ): VehicleNetworkEntity
}
