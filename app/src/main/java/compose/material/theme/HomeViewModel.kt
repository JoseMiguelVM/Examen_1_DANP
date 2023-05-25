package compose.material.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel(
    private val dao: UserDao
) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    init {
        viewModelScope.launch {
            dao.getAllUsers().collectLatest {
                state = state.copy(
                    users = it
                )
            }
        }
    }

    fun changeName(name: String) {
        state = state.copy(
            userName = name
        )
    }

    fun changeNumber(number: String) {
        state = state.copy(
            userNumber = number
        )
    }

    fun changeEmail(email: String) {
        state = state.copy(
            userEmail = email
        )
    }

    fun changePassword(password: String) {
        state = state.copy(
            userPassword = password
        )
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            dao.deleteUser(user)
        }
    }

    fun editUser(user: User) {
        state = state.copy(
            userName = user.name,
            userNumber = user.number.toString(),
            userEmail = user.email,
            userPassword = user.password,
            userId = user.id
        )
    }

    fun createUser() {
        val user =
            User(
                state.userId ?: UUID.randomUUID().toString(),
                state.userName,
                state.userNumber.toDouble(),
                state.userEmail,
                state.userPassword,
            )
        viewModelScope.launch {
            dao.insertUser(user)
        }
        state = state.copy(
            userName = "",
            userNumber = "",
            userEmail = "",
            userPassword = "",
            userId = null
        )
    }
}