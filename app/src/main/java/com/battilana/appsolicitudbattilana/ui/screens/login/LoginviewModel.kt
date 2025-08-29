package com.battilana.appsolicitudbattilana.ui.screens.login

import android.os.UserManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.navOptions
import com.battilana.appsolicitudbattilana.data.datasource.SessionManager
import com.battilana.appsolicitudbattilana.data.dto.LoginResponse
import com.battilana.appsolicitudbattilana.data.datasource.UserSession
import com.battilana.appsolicitudbattilana.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginviewModel @Inject constructor(
    private val sessionManager: SessionManager,
    private val loginRepo: UsuarioRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onLogin(username: String, password: String) {

        _uiState.update { it.copy(isLoading = true, error = null) }

        viewModelScope.launch {
            val result = loginRepo.doLogin(username, password)

            result.onSuccess { response ->
                if (response.status == "success") {

                    saveSession(response)

                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            login = response,
                            isLoggedIn = true
                        )
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = "Credenciales incorrectas"
                        )
                    }
                }
            }

            result.onFailure { e ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = "Credenciales incorrectas"
                    )
                }
                Log.e("LoginViewModel", "Login Error", e)
            }
        }
    }

    private fun saveSession(response: LoginResponse){
        viewModelScope.launch {
            sessionManager.saveSession(
                UserSession(
                    idUsuario = response.idUsuario,
                    name = response.names,
                    subname = response.subnames,
                    token = response.token,
                    status = response.status
                )
            )
        }
    }

    fun logout(){
        viewModelScope.launch {

            sessionManager.clearSession()
            _uiState.update { it.copy(isLoggedIn = false, login = null) }

            Log.i("Logout", "Sesion cerrada correctamente")
        }
    }

    fun verifyLogin(username: String, password: String) {
        val username: Boolean = username != ""
        val password: Boolean = password.length >= 8
        val enabledLogin = username && password

        _uiState.update { state ->
            state.copy(isEnabledLogin = enabledLogin)
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class LoginUiState(
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false,
    val isEnabledLogin: Boolean = false,
    val login: LoginResponse? = null,
    val error: String? = null,
)