package com.battilana.appsolicitudbattilana.data.dto

data class LoginResponse(
    val idUsuario:Long,
    val names:String,
    val subnames:String,
    val token:String,
    val status:String
)
