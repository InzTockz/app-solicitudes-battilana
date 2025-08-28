package com.battilana.appsolicitudbattilana.data.api

import com.battilana.appsolicitudbattilana.data.dto.LoginRequest
import com.battilana.appsolicitudbattilana.data.dto.LoginResponse
import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UsuarioApi {

    @POST("api/v1/usuario/login")
    suspend fun doLogin(@Body loginRequest: LoginRequest): LoginResponse

    @GET("api/v1/usuario/list")
    suspend fun doListUsuario(): List<UsuarioDto>

    @POST("api/v1/usuario/register")
    suspend fun doRegisterUsuario(@Body usuario: UsuarioDto): UsuarioDto


}