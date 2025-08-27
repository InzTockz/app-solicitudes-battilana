package com.battilana.appsolicitudbattilana.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.battilana.appsolicitudbattilana.R
import com.battilana.appsolicitudbattilana.view.core.components.BattiButton
import com.battilana.appsolicitudbattilana.view.core.components.BattiTextField

@Composable
fun LoginScreen(
    loginViewModel: LoginviewModel = viewModel(),
    navigateToPedido:() -> Unit
){

//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("")}

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

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
                    .padding(top = 40.dp),
                fontSize = 35.sp,
                text = stringResource(R.string.login_screen_header_title),
                color = Color(0xFFFF6600),
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.logo_battilana),
                contentDescription = "Logo batilaniense",
                Modifier.size(300.dp)
            )
            BattiTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.username,
                onValueChange = { loginViewModel.onUsernameChange(it)},
                text = stringResource(R.string.login_screen_textfield_username)
            )
            Spacer(Modifier.height(10.dp))
            BattiTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = uiState.password,
                onValueChange = { loginViewModel.onPasswordChange(it)},
                text = stringResource(R.string.login_screen_textfield_password)
            )
            Spacer(Modifier.height(15.dp))
            BattiButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { navigateToPedido() },
                enabled = uiState.isEnabledLogin,
                text = stringResource(R.string.login_screen_button_login)
            )
            Spacer(Modifier.weight(1f))
            Text(stringResource(R.string.login_screen_footer_text_signature))
        }
    }
}