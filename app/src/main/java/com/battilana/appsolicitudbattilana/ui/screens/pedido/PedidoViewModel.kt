package com.battilana.appsolicitudbattilana.ui.screens.pedido

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import com.battilana.appsolicitudbattilana.data.repository.UsuarioRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PedidoViewModel @Inject constructor(
    private val repo: UsuarioRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<List<UsuarioDto>>(emptyList())
    val uiState: StateFlow<List<UsuarioDto>> = _uiState
    //private val _uiState = MutableStateFlow(PedidosUiState())
    //val uiState: StateFlow<PedidosUiState> = _uiState

    fun onCantidadChange(cantidad: String) {
        //_uiState.update { state ->
        //state.copy(cantidad = cantidad)
    }

    fun getListado(){
        viewModelScope.launch {
            _uiState.value = repo.getUsuarios()
        }
    }
}

//data class PedidosUiState(
//    val articulos: List<String> = listOf(""),
//    val cantidad: String = "",
//    val stock: String = "'",
//    val comentarios: String = "",
//    val isEnableAddProduct: Boolean = false,
//    val isEnabledRegisterProduct: Boolean = false
//)