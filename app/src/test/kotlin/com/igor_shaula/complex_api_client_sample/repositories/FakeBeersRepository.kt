package com.igor_shaula.complex_api_client_sample.repositories

import com.igor_shaula.complex_api_client_sample.data.entities.BeerNetworkEntity
import com.igor_shaula.complex_api_client_sample.data.repositories.BeersRepository

object FakeBeersRepository : BeersRepository {
    override suspend fun fetchBeers(): List<BeerNetworkEntity> {
        TODO("Not yet implemented")
    }
}