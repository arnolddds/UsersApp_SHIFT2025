package com.sobolev.usersapp.data.local.models

import androidx.room.Embedded

data class LocationDbModel(
    @Embedded val street: StreetDbModel,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String
)