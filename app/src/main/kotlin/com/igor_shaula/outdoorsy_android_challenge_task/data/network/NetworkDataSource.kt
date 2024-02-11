package com.igor_shaula.outdoorsy_android_challenge_task.data.network

import com.igor_shaula.outdoorsy_android_challenge_task.data.entities.VehicleNetworkEntity
import com.igor_shaula.outdoorsy_android_challenge_task.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource {

    private val vehicleNetworkService: VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl("https://search.outdoorsy.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)

    suspend fun launchSearchRequestFor(searchQuery: String): VehicleNetworkEntity =
        vehicleNetworkService.getVehiclesList(searchQuery)
}
