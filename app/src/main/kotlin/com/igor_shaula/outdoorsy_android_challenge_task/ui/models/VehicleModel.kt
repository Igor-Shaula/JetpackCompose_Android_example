package com.igor_shaula.outdoorsy_android_challenge_task.ui.models

import com.igor_shaula.outdoorsy_android_challenge_task.data.network.OneVehicleData

// container of UI-level data for list items on screen
data class VehicleModel(
    val vehicleImage: String, // temporary - link for the image address
    val vehicleName: String
)

fun List<OneVehicleData>.toVehicleModels(): List<VehicleModel> {
    val result = mutableListOf<VehicleModel>()
    forEach {
        result.add(VehicleModel(vehicleImage = it.imageUrl, vehicleName = it.name))
    }
    return result
}
