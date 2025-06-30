package com.sobolev.usersapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("results") val results: List<UserDto>
)