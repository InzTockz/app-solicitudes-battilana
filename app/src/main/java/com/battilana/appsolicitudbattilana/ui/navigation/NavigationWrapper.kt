package com.battilana.appsolicitudbattilana.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.battilana.appsolicitudbattilana.ui.screens.login.LoginScreen
import com.battilana.appsolicitudbattilana.ui.screens.pedido.PedidoScreen
import com.battilana.appsolicitudbattilana.ui.screens.register.RegisterScreen

@Composable
fun NavigationWrapper(){
    val navigationController = rememberNavController()

    NavHost(navController = navigationController, startDestination = Login){
        composable<Login> {
            LoginScreen(navigateToPedido = { navigationController.navigate(Pedido)})
        }
        composable<Register> {
            RegisterScreen()
        }

        composable<Pedido> {
            PedidoScreen(backToLogin = {
                navigationController.popBackStack()
            })
        }
    }
}