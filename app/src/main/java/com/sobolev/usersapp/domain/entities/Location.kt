package com.sobolev.usersapp.domain.entities

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: Coordinates
) {
    val formattedAddress: String
        get() = "$street.number $street.name, $city, $state"
}