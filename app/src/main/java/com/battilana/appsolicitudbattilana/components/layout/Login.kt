package com.battilana.appsolicitudbattilana.components.layout

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.battilana.appsolicitudbattilana.R

@Composable
fun InicioSesion(modifier: Modifier) {
    var user by remember { mutableStateOf(value = "") }
    var password by remember { mutableStateOf("") }
    Login(
        modifier = modifier, user = user, onUserChange = { user = it },
        password = password, onPasswordChange = { password = it })
}

@Composable
fun Login(
    modifier: Modifier,
    user: String,
    onUserChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                //.background(Color.Black)
                .weight(3f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_battilana),
                contentDescription = "Battilogo",
                modifier = Modifier
                    .size(250.dp)
                    .padding(20.dp)
                    .clip(RoundedCornerShape(40)),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier
                //.background(Color.Black)
                .weight(7f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(Modifier.fillMaxWidth()) {
                Column(Modifier.align(Alignment.Center)) {
                    TextField(
                        user,
                        onValueChange = { onUserChange(it) },
                        label = { Text("Usuario") },
                        modifier = Modifier.clip(RoundedCornerShape(15)))
                    Spacer(Modifier.height(20.dp))
                    TextField(
                        password,
                        onValueChange = { onPasswordChange(it) },
                        label = { Text("Contraseña") },
                        modifier = Modifier.clip(RoundedCornerShape(15)))
                    Spacer(Modifier.height(50.dp))
                    Button(
                        onClick = {}, Modifier
                            .align(Alignment.CenterHorizontally)
                            .width(200.dp)
                            .height(60.dp)
                    ) {
                        Text("Iniciar sesion", fontSize = 18.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun Register() {

}