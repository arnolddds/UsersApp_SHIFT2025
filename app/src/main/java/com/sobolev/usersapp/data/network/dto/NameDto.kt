package com.sobolev.usersapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)