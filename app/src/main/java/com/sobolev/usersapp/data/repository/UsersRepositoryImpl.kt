package com.sobolev.usersapp.data.repository

import com.sobolev.usersapp.data.local.db.UsersDao
import com.sobolev.usersapp.data.local.models.UserDbModel
import com.sobolev.usersapp.data.mapper.toDbModel
import com.sobolev.usersapp.data.mapper.toDomain
import com.sobolev.usersapp.data.network.ApiService
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val usersDao: UsersDao
) : UsersRepository {

    override fun getAllUsers(): Flow<List<User>> {
        return usersDao.getAllUsers()
            .map { list: List<UserDbModel> -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getUser(userId: Int): User {
        return usersDao.getUser(userId).toDomain()
    }

    override suspend fun refreshUsers() {
        val remoteUsers = apiService.getAllUsers(50).results
        val dbModels = remoteUsers.map { it.toDbModel() }
        usersDao.clearAll()
        usersDao.insertAll(dbModels)
    }

}

