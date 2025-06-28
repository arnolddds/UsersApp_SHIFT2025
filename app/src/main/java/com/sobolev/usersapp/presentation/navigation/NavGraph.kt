package com.sobolev.usersapp.presentation.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.presentation.screens.details.UserDetailsScreen
import com.sobolev.usersapp.presentation.screens.users.UsersScreen

@Composable
fun NavGraph(users: List<User>) {
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
                users = users
            )
        }
        composable(Screen.UserInfo.route) {
            val userId = Screen.UserInfo.getUserId(it.arguments)
            UserDetailsScreen(
                user = users[0],
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }

}

sealed class Screen(val route:String) {

    data object Users : Screen("users")

    data object UserInfo: Screen("user_info/{user_id}") {
        fun createRoute(userId:Int) = "user_info/$userId"

        fun getUserId(arguments:Bundle?): Int {
            return arguments?.getString("user_id")?.toInt() ?: 0
        }
    }
}