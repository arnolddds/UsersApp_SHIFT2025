package com.sobolev.usersapp.domain.usecases

import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.repository.UsersRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    suspend operator fun invoke(userId: Int): User {
        return repository.getUser(userId)
    }
}