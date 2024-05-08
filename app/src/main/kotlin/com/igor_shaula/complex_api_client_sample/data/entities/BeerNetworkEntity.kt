package com.igor_shaula.complex_api_client_sample.data.entities

import com.google.gson.annotations.SerializedName

data class BeerNetworkEntity(
//    @SerializedName("name") val name: String,
//    @SerializedName("description") val description: String,
//    @SerializedName("food_pairing") val foodPairings: List<String>?
    @SerializedName("price") val price: String,
    @SerializedName("name") val name: String,
    @SerializedName("rating") val rating: BeerRating,
    @SerializedName("image") val image: String,
    @SerializedName("id") val id: Int
)

data class BeerRating(
    @SerializedName("average") val average: Double,
    @SerializedName("reviews") val reviews: Int
)
