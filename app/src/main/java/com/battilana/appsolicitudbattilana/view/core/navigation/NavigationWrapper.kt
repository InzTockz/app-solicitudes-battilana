package com.battilana.appsolicitudbattilana.view.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.battilana.appsolicitudbattilana.view.auth.login.LoginScreen
import com.battilana.appsolicitudbattilana.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper(){
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Login){
        composable<Login> {
            LoginScreen()
        }
        composable<Register> {
            RegisterScreen()
        }
    }
}