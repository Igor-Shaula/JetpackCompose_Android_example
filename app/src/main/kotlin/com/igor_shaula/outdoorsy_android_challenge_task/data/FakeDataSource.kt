package com.igor_shaula.outdoorsy_android_challenge_task.data

import com.igor_shaula.outdoorsy_android_challenge_task.ui.models.VehicleModel

class FakeDataSource {

    companion object {

        // temporary here - later the data will be moved on its own layer
        val fakeVehiclesList = listOf(
            VehicleModel("image-address-1", "name-1"),
            VehicleModel("image-address-2", "name-2"),
            VehicleModel("image-address-3", "name-3"),
            VehicleModel("image-address-4", "name-4"),
            VehicleModel("image-address-5", "name-5"),
        )
    }
}