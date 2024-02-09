package com.igor_shaula.outdoorsy_android_challenge_task.data.network

import com.igor_shaula.outdoorsy_android_challenge_task.data.network.retrofit.VehicleRetrofitNetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkDataSource {

    private val vehicleNetworkService: VehicleRetrofitNetworkService =
        Retrofit.Builder()
            .baseUrl("https://search.outdoorsy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VehicleRetrofitNetworkService::class.java)

//    private val testBeerService: TestBeerService = Retrofit.Builder()
//        .baseUrl("https://api.punkapi.com/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(TestBeerService::class.java)

    suspend fun launchSearchRequestFor(searchQuery: String) {
        val response = vehicleNetworkService.getVehiclesList(searchQuery)
        println(response)
        println(response.body())
    }
}