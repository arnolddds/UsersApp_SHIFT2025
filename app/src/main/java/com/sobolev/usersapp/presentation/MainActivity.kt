package com.sobolev.usersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sobolev.usersapp.domain.entities.Location
import com.sobolev.usersapp.domain.entities.Name
import com.sobolev.usersapp.domain.entities.Picture
import com.sobolev.usersapp.domain.entities.Street
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.presentation.navigation.NavGraph
import com.sobolev.usersapp.presentation.screens.details.UserDetailsScreen
import com.sobolev.usersapp.presentation.screens.users.UsersScreen
import com.sobolev.usersapp.presentation.ui.theme.UsersAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UsersAppTheme {
                NavGraph()
            }
        }
    }
}

