package com.battilana.appsolicitudbattilana.data.model

data class UserSession(
    val idUsuario:Long=0,
    val name:String="",
    val subname:String="",
    val token:String="",
    val status:String=""
)
