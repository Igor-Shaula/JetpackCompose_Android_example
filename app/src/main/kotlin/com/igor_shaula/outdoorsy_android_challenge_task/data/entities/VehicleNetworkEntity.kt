package com.igor_shaula.outdoorsy_android_challenge_task.data.entities

import com.google.gson.annotations.SerializedName

data class VehicleNetworkEntity(
    @SerializedName("") val vehicleImageUrl: String,
    @SerializedName("") val vehicleName: String
)