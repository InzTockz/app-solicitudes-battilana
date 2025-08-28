package com.battilana.appsolicitudbattilana.data.repository

import com.battilana.appsolicitudbattilana.data.api.UsuarioApi
import com.battilana.appsolicitudbattilana.data.dto.LoginRequest
import com.battilana.appsolicitudbattilana.data.dto.LoginResponse
import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import javax.inject.Inject

class UsuarioRepository @Inject constructor(private val usuarioApi: UsuarioApi) {

    suspend fun getUsuarios(): List<UsuarioDto> = usuarioApi.doListUsuario()


    suspend fun doLogin(username:String, password:String): Result<LoginResponse>{
        val request = LoginRequest(username, password)
        val response = usuarioApi.doLogin(request)
        return Result.success(response)
    }
}