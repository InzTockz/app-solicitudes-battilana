@file:OptIn(ExperimentalMaterial3Api::class)

package com.battilana.appsolicitudbattilana.view.auth.pedido

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.battilana.appsolicitudbattilana.R

@Composable
fun PedidoScreen(
    backToLogin:() -> Unit,
    pedidoViewModel: PedidoViewModel = viewModel()
) {
    var isDropDownEnabled by remember { mutableStateOf(false) }
    val uiStatePedido by pedidoViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold (
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            //Titulo o encabezado
            Text(
                modifier = Modifier
                    .padding(top = 15.dp),
                text = stringResource(id = R.string.pedido_screen_header_title),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(10.dp))
            //Combo box de los productos battilana
            ExposedDropdownMenuBox( expanded = isDropDownEnabled, onExpandedChange = { isDropDownEnabled = it }
            )
            {
                OutlinedTextField(
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor(type = MenuAnchorType.PrimaryNotEditable)
                        .fillMaxWidth(),

                    value = "",
                    shape = RoundedCornerShape(25),
                    onValueChange = { isDropDownEnabled = !isDropDownEnabled},
                    label = { Text( text = stringResource(id = R.string.pedido_screen_dropdown_articulos)) },

                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = isDropDownEnabled,
                            Modifier.size(35.dp)
                        )
                    }
                )
                ExposedDropdownMenu(
                    expanded = isDropDownEnabled,
                    onDismissRequest = { isDropDownEnabled = false }
                )
                {
                    DropdownMenuItem(
                        text = { Text("Hola") },
                        onClick = {}
                    )
                    DropdownMenuItem(
                        text = { Text("Hola") },
                        onClick = {}
                    )
                }
            }
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                //Caja para la cantidad
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f),
                    value = uiStatePedido.cantidad,
                    onValueChange = { pedidoViewModel.onCantidadChange( cantidad = it)},
                    shape = RoundedCornerShape(25),
                    label = { Text(text = stringResource(id = R.string.pedido_screen_textfield_cantidad))}
                )
                Spacer(Modifier.width(5.dp))
                //Caja para mostrar el stock disponible
                OutlinedTextField(
                    modifier = Modifier
                        .weight(0.5f),
                    value = "",
                    onValueChange = {},
                    shape = RoundedCornerShape(25),
                    label = { Text(text = stringResource(id = R.string.pedido_screen_textfield_stock))}
                )
            }
            Spacer(Modifier.height(5.dp))
            //Caja de Comentario
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                shape = RoundedCornerShape(25),
                label = { Text(text = stringResource(id = R.string.pedido_screen_textfield_comentario))}
            )
            Spacer(Modifier.height(5.dp))
            //Boton para agregar productos
            Button(
                onClick = {}
            ) { Text(text = stringResource(id = R.string.pedido_screen_button_agregar_producto))}
            //Boton de registro articulo unidad
            Spacer(Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {},
            )
            {
                Text(text = stringResource(id = R.string.pedido_screen_button_registrar_pedido))
            }
            Row {
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {}
                )
                {
                    Text(text = stringResource(id = R.string.pedido_screen_button_limpiar))
                }
                Spacer(Modifier.width(10.dp))
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f),
                    onClick = {}
                )
                {
                    Text(
                        text = stringResource(id = R.string.pedido_screen_button_cancelar)
                    )
                }
            }
            Button(
                onClick = {backToLogin()}
            ) {
                Text("Volver al futuro")
            }
        }
    }
}