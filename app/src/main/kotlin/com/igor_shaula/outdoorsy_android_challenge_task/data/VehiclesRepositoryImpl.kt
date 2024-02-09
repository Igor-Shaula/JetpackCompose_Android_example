package com.igor_shaula.outdoorsy_android_challenge_task.data

class VehiclesRepositoryImpl : VehiclesRepository {

    override suspend fun launchSearchRequestFor(searchQuery: String) {
        println("launchSearchRequestFor: searchQuery = $searchQuery")
    }
}
