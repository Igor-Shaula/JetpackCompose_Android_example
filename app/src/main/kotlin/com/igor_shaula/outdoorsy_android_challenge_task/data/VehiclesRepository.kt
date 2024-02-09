package com.igor_shaula.outdoorsy_android_challenge_task.data

interface VehiclesRepository {

    suspend fun launchSearchRequestFor(searchQuery: String)
}