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
            result = Result.failure(NetworkGeneralFailure(initialThrowable = it))
        }.onSuccess {
            println("updateSearchRequest: onSuccess")
            result = if (response?.isSuccessful == true) {
                println("response.isSuccessful")
                Result.success(response?.body()) // all normal data-flow goes here
            } else if (response == null) {
                println("response is NULL for some network-agent reason")
                Result.failure(NetworkGeneralFailure(errorMessage = ABSENT_RESPONSE_MESSAGE))
            } else {
                println("response exists but is NOT successful")
                val errorCode = response?.code() ?: NetworkGeneralFailure.ABSENT_ERROR_CODE
                val errorBody =
                    response?.errorBody()?.string() ?: NetworkGeneralFailure.ABSENT_ERROR_MESSAGE
                Result.failure(
                    NetworkGeneralFailure(errorCode = errorCode, errorMessage = errorBody)
                )
            }
        }
        return result
    }
}
