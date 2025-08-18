package com.battilana.appsolicitudbattilana.view.auth.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginviewModel: ViewModel (){
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onUsernameChange(username:String){
        _uiState.update { state ->
            state.copy(username = username)
        }
        verifyLogin()
    }

    fun onPasswordChange(password: String){
        _uiState.update { state ->
            state.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin(){
        val enabledLogin =
            isUsernameValid(_uiState.value.username) && isPasswordValid(_uiState.value.password)
        _uiState.update { state ->
            state.copy(isEnabledLogin = enabledLogin)
        }
    }

    private fun isUsernameValid(username: String): Boolean = username != ""
    private fun isPasswordValid(password: String): Boolean = password.length >= 8
}

data class LoginUiState(
    val username:String = "",
    val password:String = "",
    val isEnabledLogin: Boolean = false
)