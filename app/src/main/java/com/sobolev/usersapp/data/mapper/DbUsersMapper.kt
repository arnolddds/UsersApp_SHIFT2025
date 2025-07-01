package com.sobolev.usersapp.data.mapper

import com.sobolev.usersapp.data.local.models.LocationDbModel
import com.sobolev.usersapp.data.local.models.LoginDbModel
import com.sobolev.usersapp.data.local.models.NameDbModel
import com.sobolev.usersapp.data.local.models.PictureDbModel
import com.sobolev.usersapp.data.local.models.RegistrationDateDbModel
import com.sobolev.usersapp.data.local.models.StreetDbModel
import com.sobolev.usersapp.data.local.models.UserDbModel
import com.sobolev.usersapp.domain.entities.Location
import com.sobolev.usersapp.domain.entities.Login
import com.sobolev.usersapp.domain.entities.Name
import com.sobolev.usersapp.domain.entities.Picture
import com.sobolev.usersapp.domain.entities.Registration
import com.sobolev.usersapp.domain.entities.Street
import com.sobolev.usersapp.domain.entities.User

fun UserDbModel.toDomain(): User {
    return User(
        id = id,
        gender = gender,
        name = name.toDomain(),
        location = location.toDomain(),
        email = email,
        phone = phone,
        cell = cell,
        picture = picture.toDomain(),
        nat = nat,
        dob = dob,
        login = login.toDomain(),
        registered = registered.toDomain()
    )
}

fun RegistrationDateDbModel.toDomain(): Registration {
    return Registration(
        date = date,
        age = age
    )
}
fun LoginDbModel.toDomain(): Login {
    return Login(
        username = username
    )
}


fun NameDbModel.toDomain(): Name {
    return Name(
        title = title,
        first = first,
        last = last
    )
}

fun LocationDbModel.toDomain(): Location {
    return Location(
        street = street.toDomain(),
        city = city,
        state = state,
        country = country,
        postcode = postcode
    )
}

fun StreetDbModel.toDomain(): Street {
    return Street(
        number = number,
        name = name
    )
}

fun PictureDbModel.toDomain(): Picture {
    return Picture(
        large = large,
        medium = medium,
        thumbnail = thumbnail
    )
}


