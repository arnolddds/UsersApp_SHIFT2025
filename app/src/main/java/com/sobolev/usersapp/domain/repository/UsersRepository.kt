package com.sobolev.usersapp.domain.repository

import com.sobolev.usersapp.domain.entities.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    fun getAllUsers(): Flow<List<User>>

    suspend fun getUser(userId: Int): User

    suspend fun refreshUsers()

}