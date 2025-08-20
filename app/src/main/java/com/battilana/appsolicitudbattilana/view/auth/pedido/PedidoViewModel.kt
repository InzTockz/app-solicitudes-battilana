package com.battilana.appsolicitudbattilana.view.auth.pedido

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PedidoViewModel: ViewModel(){

    private val _uiState = MutableStateFlow(PedidosUiState())
    val uiState: StateFlow<PedidosUiState> = _uiState

    fun onCantidadChange(cantidad: String){
        _uiState.update { state ->
            state.copy(cantidad = cantidad)
        }
    }
}

data class PedidosUiState(
    val articulos: List<String> = listOf("") ,
    val cantidad: String = "",
    val stock: String = "'",
    val comentarios:String = "",
    val isEnableAddProduct: Boolean = false,
    val isEnabledRegisterProduct: Boolean = false
)