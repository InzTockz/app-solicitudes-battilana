package com.battilana.appsolicitudbattilana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.battilana.appsolicitudbattilana.components.layout.InicioSesion
import com.battilana.appsolicitudbattilana.components.layout.Login
import com.battilana.appsolicitudbattilana.ui.theme.AppSolicitudBattilanaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                InicioSesion(Modifier.padding(innerPadding))
            }
        }
    }
}