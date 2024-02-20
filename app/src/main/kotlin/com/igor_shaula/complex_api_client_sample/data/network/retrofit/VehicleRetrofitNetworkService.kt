package com.igor_shaula.complex_api_client_sample.data.network.retrofit

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleRetrofitNetworkService {

    @GET("/rentals")
    suspend fun getVehiclesList(
        @Query("filter[keywords]") searchQuery: String,
        @Query("page[limit]") pageLimit: Int = 8, // paging will be configured later
        @Query("page[offset]") pageOffset: Int = 8 // paging will be configured later
    ): VehicleNetworkEntity
}
