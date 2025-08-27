package com.battilana.appsolicitudbattilana.view.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.battilana.appsolicitudbattilana.R

@Composable
fun BattiButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = text,
        )
    }
}

@Composable
fun BattiOutButton(
    modifier: Modifier = Modifier,
    onClick:() -> Unit,
    text:String
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick
    )
    {
        Text(text = text)
    }
}