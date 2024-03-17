package com.project.id4you.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight

@Suppress("LongParameterList")
@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    labelText: String,
    textColor: Color,
    buttonColor: Color,
    method: () -> Unit = {},
    fontWeight: Int = 500
) {
    Button(
        onClick = method,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor
        )
    ) {
        Text(labelText, fontWeight = FontWeight(fontWeight))
    }
}
