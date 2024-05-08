package com.igor_shaula.complex_api_client_sample.data.repositories

import com.igor_shaula.complex_api_client_sample.data.entities.BeerNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.network.retrofit.BeerRetrofitNetworkService
import javax.inject.Inject

interface BeersRepository {

    suspend fun fetchBeers(): List<BeerNetworkEntity>
}

// at the moment there is no need to add a BeersDataSource as the code is too easy
class BeersRepositoryImpl @Inject constructor(
    private val beerService: BeerRetrofitNetworkService
) : BeersRepository {

    override suspend fun fetchBeers(): List<BeerNetworkEntity> {
        return beerService.getBeers()
    }
}
