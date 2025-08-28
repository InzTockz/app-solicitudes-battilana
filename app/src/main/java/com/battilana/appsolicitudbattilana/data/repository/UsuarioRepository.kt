package com.battilana.appsolicitudbattilana.data.repository

import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import com.battilana.appsolicitudbattilana.data.dto.LoginRequest
import com.battilana.appsolicitudbattilana.data.dto.LoginResponse
import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import javax.inject.Inject

class UsuarioRepository @Inject constructor(private val usuarioApi: UsuarioApi) {

    suspend fun getUsuarios(): List<UsuarioDto> = usuarioApi.doListUsuario()


    suspend fun doLogin(loginRequest: LoginRequest): Result<LoginResponse>{
        val response = usuarioApi.doLogin(loginRequest)
        return Result.success(response)
    }
}