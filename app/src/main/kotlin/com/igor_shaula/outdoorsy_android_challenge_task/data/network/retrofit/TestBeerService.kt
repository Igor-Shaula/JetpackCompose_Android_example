package com.igor_shaula.outdoorsy_android_challenge_task.data.network.retrofit

import com.igor_shaula.outdoorsy_android_challenge_task.data.entities.BeerNetworkEntity
import retrofit2.http.GET

interface TestBeerService {

    @GET("v2/beers")
    suspend fun getBeers(): List<BeerNetworkEntity>
}
