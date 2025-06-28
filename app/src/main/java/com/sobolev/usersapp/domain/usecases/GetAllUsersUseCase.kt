package com.sobolev.usersapp.domain.usecases

import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow

class GetAllUsersUseCase(
    private val repository: UsersRepository
) {

    operator fun invoke(): Flow<List<User>> {
        return repository.getAllUsers()
    }
}