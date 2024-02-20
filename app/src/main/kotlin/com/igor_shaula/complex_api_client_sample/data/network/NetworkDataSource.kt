package com.igor_shaula.complex_api_client_sample.data.network

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource {

    private val vehicleNetworkService: VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)

    suspend fun launchSearchRequestFor(searchQuery: String): VehicleNetworkEntity? {
        var response: Response<VehicleNetworkEntity>? = null

        runCatching {
            response = vehicleNetworkService.getVehiclesList(searchQuery)
        }.onFailure {
            println("updateSearchRequest: onFailure: $it")
        }.onSuccess {
            println("updateSearchRequest: onSuccess")
        }

        return if (response?.isSuccessful == true) {
            println("response.isSuccessful")
            response?.body()
        } else {
            println("response not successful")
            null
        }
    }
}
