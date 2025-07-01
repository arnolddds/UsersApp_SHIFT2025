package com.sobolev.usersapp.domain.usecases

import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.repository.UsersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    operator fun invoke(): Flow<List<User>> = repository.getAllUsers()
}
