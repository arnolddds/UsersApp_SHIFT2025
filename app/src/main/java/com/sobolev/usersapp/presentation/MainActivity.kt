package com.sobolev.usersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sobolev.usersapp.domain.entities.Coordinates
import com.sobolev.usersapp.domain.entities.Location
import com.sobolev.usersapp.domain.entities.Name
import com.sobolev.usersapp.domain.entities.Picture
import com.sobolev.usersapp.domain.entities.Street
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.presentation.navigation.NavGraph
import com.sobolev.usersapp.presentation.screens.details.UserDetailsScreen
import com.sobolev.usersapp.presentation.screens.users.UsersScreen
import com.sobolev.usersapp.presentation.ui.theme.UsersAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val users = mutableListOf<User>()
        for (i in 1..50) {
            users.add(
                User(
                    id = i,
                    gender = "male",
                    name = Name(
                        title = "Mr",
                        first = "Arnold",
                        last = "Schwarzenegger"
                    ),
                    location = Location(
                        street = Street(number = 123, name = "Hollywood Blvd"),
                        city = "Los Angeles",
                        state = "California",
                        country = "USA",
                        postcode = "90210",
                        coordinates = Coordinates(latitude = "34.0522", longitude = "-118.2437")
                    ),
                    email = "arnold${i}@example.com",
                    phone = "+1 555 010${i.toString().padStart(2, '0')}",
                    cell = "+1 555 020${i.toString().padStart(2, '0')}",
                    picture = Picture(
                        large = "https://example.com/large.jpg",
                        medium = "https://example.com/medium.jpg",
                        thumbnail = "https://example.com/thumb.jpg"
                    ),
                    nat = "US"
                )
            )
        }
        setContent {
            UsersAppTheme {
                NavGraph(users = users)
            }
        }
    }
}

