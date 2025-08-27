package com.battilana.appsolicitudbattilana.data.repository

import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import javax.inject.Inject

class UsuarioRepository @Inject constructor(private val usuarioApi: UsuarioApi) {

    suspend fun getUsuarios(): List<UsuarioDto>{
        return usuarioApi.doListUsuario()
    }
}