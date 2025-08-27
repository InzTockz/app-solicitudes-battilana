package com.battilana.appsolicitudbattilana.data.api

import com.battilana.appsolicitudbattilana.data.dto.UsuarioDto
import retrofit2.http.GET

interface UsuarioApi {

    @GET("api/v1/usuario/list")
    suspend fun doListUsuario(): List<UsuarioDto>
}