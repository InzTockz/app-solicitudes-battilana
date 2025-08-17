package com.battilana.appsolicitudbattilana.view.auth.login

import android.widget.HorizontalScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.battilana.appsolicitudbattilana.R

@Composable
fun LoginScreen(){

    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("")}

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 30.dp),
                fontSize = 30.sp,
                text = "Solicitudes Battilana"
            )
            Image(
                painter = painterResource(id = R.drawable.logo_battilana),
                contentDescription = "Logo batilaniense",
                Modifier.size(300.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = usuario,
                onValueChange = { usuario = it},
                shape = RoundedCornerShape(35),
                label = {
                    Text(
                        text = "Usuario"
                    )
                }
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = contraseña,
                onValueChange = { contraseña = it},
                shape = RoundedCornerShape(35),
                label = {
                    Text(
                        text = "Contraseña"
                    )
                }
            )
            Spacer(Modifier.height(15.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    text = "Iniciar Sesion"
                )
            }
            Spacer(Modifier.weight(1f))
            Text("Developed by FHHF")
        }
    }
}