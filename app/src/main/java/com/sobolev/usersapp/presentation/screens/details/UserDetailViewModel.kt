package com.sobolev.usersapp.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sobolev.usersapp.domain.entities.User
import com.sobolev.usersapp.domain.usecases.GetUserUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel(assistedFactory = UserDetailViewModel.Factory::class)
class UserDetailViewModel @AssistedInject constructor(
    @Assisted("userId") private val userId: Int,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UserDetailState>(UserDetailState.Initial)
    val state = _state.asStateFlow()

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("userId") userId: Int
        ): UserDetailViewModel
    }

    init {
        viewModelScope.launch {
            _state.update {
                val user = getUserUseCase(userId)
                UserDetailState.Checking(user)
            }
        }
    }

    fun processCommand(command: UserDetailCommand) {
        when (command) {
            UserDetailCommand.Back -> {
                _state.update {
                    UserDetailState.Finished
                }
            }
        }
    }


}

sealed interface UserDetailCommand {

    data object Back : UserDetailCommand
}

sealed interface UserDetailState {

    data object Initial : UserDetailState

    data class Checking(
        val user: User
    ) : UserDetailState

    data object Finished : UserDetailState

}