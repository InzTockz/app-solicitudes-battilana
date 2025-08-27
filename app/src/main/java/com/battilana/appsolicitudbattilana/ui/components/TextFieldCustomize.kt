package com.battilana.appsolicitudbattilana.view.core.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import com.battilana.appsolicitudbattilana.R

@Composable
fun BattiTextField(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange:(String) -> Unit,
    shape: Shape = RoundedCornerShape(25),
    text:String
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        shape = shape,
        label = { Text(text = text)}
    )
}