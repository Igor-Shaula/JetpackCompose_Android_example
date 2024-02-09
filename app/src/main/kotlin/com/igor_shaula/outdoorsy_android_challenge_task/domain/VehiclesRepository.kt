package com.igor_shaula.outdoorsy_android_challenge_task.domain

interface VehiclesRepository {

    suspend fun launchSearchRequestFor(searchQuery: String)
}