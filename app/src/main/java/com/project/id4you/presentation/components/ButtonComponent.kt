package com.project.id4you.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Suppress("LongParameterList")
@Composable
fun ButtonComponent(
    labelText: String,
    textColor: Color,
    buttonColor: Color,
    method: () -> Unit = {},
    fontWeight: Int = 500,
    passedButtonModifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
    passedColumnModifier: Modifier = Modifier
        .fillMaxSize(),
    vertical: Arrangement.Vertical = Arrangement.spacedBy(8.dp)
) {
    Column(
        verticalArrangement = vertical,
        modifier = passedColumnModifier
    ) {
        Button(
            onClick = method,
            modifier = passedButtonModifier,
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor,
                contentColor = textColor
            )
        ) {
            Text(labelText, fontWeight = FontWeight(fontWeight))
        }
    }
}
