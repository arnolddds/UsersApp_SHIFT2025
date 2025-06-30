package com.sobolev.usersapp.data.mapper

import com.sobolev.usersapp.data.local.models.LocationDbModel
import com.sobolev.usersapp.data.local.models.NameDbModel
import com.sobolev.usersapp.data.local.models.PictureDbModel
import com.sobolev.usersapp.data.local.models.StreetDbModel
import com.sobolev.usersapp.data.local.models.UserDbModel
import com.sobolev.usersapp.data.network.dto.LocationDto
import com.sobolev.usersapp.data.network.dto.NameDto
import com.sobolev.usersapp.data.network.dto.PictureDto
import com.sobolev.usersapp.data.network.dto.StreetDto
import com.sobolev.usersapp.data.network.dto.UserDto
import com.sobolev.usersapp.domain.entities.Location
import com.sobolev.usersapp.domain.entities.Name
import com.sobolev.usersapp.domain.entities.Picture
import com.sobolev.usersapp.domain.entities.Street
import com.sobolev.usersapp.domain.entities.User

fun UserDto.toDomain(): User {
    return User(
        id = email.hashCode(),
        gender = gender,
        name = name.toDomain(),
        location = location.toDomain(),
        email = email,
        phone = phone,
        cell = cell,
        picture = picture.toDomain(),
        nat = nationality,
        dob = dob?.age.toString()
    )
}

fun UserDto.toDbModel(): UserDbModel {
    return UserDbModel(
        id = email.hashCode(),
        gender = gender,
        name = name.toDbModel(),
        location = location.toDbModel(),
        email = email,
        phone = phone,
        cell = cell,
        picture = picture.toDbModel(),
        nat = nationality,
        dob = dob?.age.toString()
    )
}

fun NameDto.toDomain(): Name {
    return Name(
        title = title,
        first = first,
        last = last
    )
}

fun NameDto.toDbModel(): NameDbModel {
    return NameDbModel(
        title = title,
        first = first,
        last = last
    )
}

fun LocationDto.toDomain(): Location {
    return Location(
        street = street.toDomain(),
        city = city,
        state = state,
        country = country,
        postcode = postcode
    )
}

fun LocationDto.toDbModel(): LocationDbModel {
    return LocationDbModel(
        street = street.toDbModel(),
        city = city,
        state = state,
        country = country,
        postcode = postcode
    )
}


fun StreetDto.toDomain(): Street {
    return Street(
        number = number,
        name = name
    )
}

fun StreetDto.toDbModel(): StreetDbModel {
    return StreetDbModel(
        number = number,
        name = name
    )
}


fun PictureDto.toDomain(): Picture {
    return Picture(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}

fun PictureDto.toDbModel(): PictureDbModel {
    return PictureDbModel(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}



