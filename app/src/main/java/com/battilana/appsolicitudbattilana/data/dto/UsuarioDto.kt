package com.battilana.appsolicitudbattilana.data.dto

import java.time.LocalDate
import java.util.Date

data class UsuarioDto(
    val idUsuario: Long,
    val names: String,
    val subnames: String,
    val email: String,
    val createAt: String,
    val status: Boolean,
    val username: String,
    val password: String,
    val roles: String
)
