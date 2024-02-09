package com.igor_shaula.outdoorsy_android_challenge_task.data

import com.igor_shaula.outdoorsy_android_challenge_task.data.network.NetworkDataSource
import com.igor_shaula.outdoorsy_android_challenge_task.domain.VehiclesRepository

class VehiclesRepositoryImpl : VehiclesRepository {

    private val dataSource = NetworkDataSource()

    override suspend fun launchSearchRequestFor(searchQuery: String) {
        println("launchSearchRequestFor: searchQuery = $searchQuery")
        dataSource.launchSearchRequestFor(searchQuery)
    }
}
