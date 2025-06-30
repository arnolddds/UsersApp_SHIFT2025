package com.sobolev.usersapp.presentation.navigation

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.presentation.screens.details.UserDetailsScreen
import com.sobolev.usersapp.presentation.screens.users.UsersScreen
import com.sobolev.usersapp.presentation.screens.users.UsersViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Users.route
    ) {
        composable(Screen.Users.route) {
            UsersScreen(
                onUserClick = {
                    navController.navigate(Screen.UserInfo.createRoute(it.id))
                },
            )
        }

        composable(Screen.UserInfo.route) {
            val userId = Screen.UserInfo.getUserId(it.arguments)
            UserDetailsScreen(
                userId = userId,
                onFinished = {
                    navController.popBackStack()
                }
            )
        }
    }

}

sealed class Screen(val route: String) {

    data object Users : Screen("users")

    data object UserInfo : Screen("user_info/{user_id}") {
        fun createRoute(userId: Int) = "user_info/$userId"

        fun getUserId(arguments: Bundle?): Int {
            return arguments?.getString("user_id")?.toIntOrNull() ?: 0
        }
    }
}