package com.igor_shaula.outdoorsy_android_challenge_task.data.entities

import com.google.gson.annotations.SerializedName

data class BeerNetworkEntity(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("food_pairing")
    val foodPairings: List<String>?
)
