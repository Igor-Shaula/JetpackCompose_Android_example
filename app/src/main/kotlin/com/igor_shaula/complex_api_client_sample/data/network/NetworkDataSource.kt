package com.igor_shaula.complex_api_client_sample.data.network

import com.igor_shaula.complex_api_client_sample.data.entities.VehicleNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class NetworkDataSource {

    private val vehicleNetworkService: VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)

    suspend fun launchSearchRequestFor(searchQuery: String): Result<VehicleNetworkEntity?> {

        var response: Response<VehicleNetworkEntity>? = null
        var result: Result<VehicleNetworkEntity?> = Result.failure(IOException()) // just a stub

        runCatching {
            response = vehicleNetworkService.getVehiclesList(searchQuery)
        }.onFailure { // here we even do not have the "response" instance, only the error
            println("updateSearchRequest: onFailure: $it")
            result = Result.failure(it)
        }.onSuccess {
            println("updateSearchRequest: onSuccess")
            result = if (response?.isSuccessful == true) {
                println("response.isSuccessful")
                Result.success(response?.body())
            } else {
                println("response is NOT successful")
                val errorCode = response?.code() ?: -1
                val errorBody = response?.errorBody()?.string()
                Result.failure(NetworkGeneralFailure(errorCode, errorBody))
            }
        }
        return result
    }
}
