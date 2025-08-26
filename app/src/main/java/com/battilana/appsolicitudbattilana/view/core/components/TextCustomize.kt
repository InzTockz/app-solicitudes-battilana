package com.battilana.appsolicitudbattilana.view.core.components

import android.graphics.Paint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.battilana.appsolicitudbattilana.R

@Composable
fun BattiTextTitle(
    modifier: Modifier = Modifier,
    text:String,
    style: TextStyle = MaterialTheme.typography.headlineLarge
){
    Text(
        modifier = modifier
            .padding(top = 15.dp),
        text = text,
        style = style
    )
}

@Composable
fun BattiTextButton(
    modifier: Modifier = Modifier,
    text:String
){
    Text(
        modifier = modifier,
        text = text
    )
}