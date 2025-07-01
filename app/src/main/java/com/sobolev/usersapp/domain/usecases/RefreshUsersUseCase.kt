package com.sobolev.usersapp.domain.usecases

import com.sobolev.usersapp.domain.repository.UsersRepository
import javax.inject.Inject

class RefreshUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {
    suspend operator fun invoke() = repository.refreshUsers()
}