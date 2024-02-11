package com.igor_shaula.outdoorsy_android_challenge_task.domain

import com.igor_shaula.outdoorsy_android_challenge_task.data.network.OneVehicleData

interface VehiclesRepository {

    suspend fun launchSearchRequestFor(searchQuery: String): List<OneVehicleData>
}
