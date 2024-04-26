package com.igor_shaula.complex_api_client_sample.ui.models

import com.igor_shaula.complex_api_client_sample.data.network.OneVehicleData

// container of UI-level data for list items on screen
data class TheUiModel(
    val image: String, // temporary - link for the image address
    val name: String
)

fun List<OneVehicleData>.toTheUiModels(): List<TheUiModel> {
    val result = mutableListOf<TheUiModel>()
    forEach {
        result.add(TheUiModel(image = it.imageUrl, name = it.name))
    }
    return result
}
