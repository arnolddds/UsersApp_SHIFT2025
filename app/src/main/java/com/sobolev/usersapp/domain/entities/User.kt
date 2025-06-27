package com.sobolev.usersapp.domain.entities

data class User(
    val id: Int,
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val phone: String,
    val cell: String,
    val picture: Picture,
    val nat: String
) {
    val fullName: String
        get() = "${name.title} ${name.first} ${name.last}"
}