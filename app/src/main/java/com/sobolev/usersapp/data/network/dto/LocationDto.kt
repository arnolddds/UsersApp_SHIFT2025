package com.sobolev.usersapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class LocationDto(
    @SerializedName("street") val street: StreetDto,
    @SerializedName("city") val city: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: String
)