package com.sobolev.usersapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("username") val username: String
)