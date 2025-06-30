package com.sobolev.usersapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class RegistrationDateDto(
    @SerializedName("date") val date: String,
    @SerializedName("age") val age: Int
)