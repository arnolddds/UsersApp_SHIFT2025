package com.sobolev.usersapp.presentation.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.usecases.GetAllUsersUseCase
import com.sobolev.usersapp.domain.usecases.RefreshUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val refreshUsersUseCase: RefreshUsersUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(UsersScreenState(isLoading = true))
    val screenState = _screenState.asStateFlow()

    init {
        observeUsers()
    }

    private fun observeUsers() {
        viewModelScope.launch {
            getAllUsersUseCase()
                .onStart {
                    _screenState.update { it.copy(isLoading = true, error = null) }
                }
                .catch { e ->
                    _screenState.update {
                        it.copy(error = e.message ?: "Ошибка загрузки", isLoading = false)
                    }
                }
                .collect { users ->
                    _screenState.update {
                        it.copy(allUsers = users, isLoading = false, error = null)
                    }


                    if (users.isEmpty()) {
                        refresh()
                    }
                }
        }
    }


    fun refresh() {
        viewModelScope.launch {
            try {
                _screenState.update { it.copy(isLoading = true, error = null) }
                refreshUsersUseCase()
            } catch (e: Exception) {
                _screenState.update { it.copy(error = e.message ?: "Ошибка обновления") }
            } finally {
                _screenState.update { it.copy(isLoading = false) }
            }
        }
    }
}


data class UsersScreenState(
    val allUsers: List<User> = listOf(),
    val isLoading: Boolean = false,
    val error: String? = null
)
