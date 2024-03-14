package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.ui.theme.Blue


@Composable
fun TextField(
    labelText: String,
    color: Color = Blue,
    borderWidth: Dp = 1.dp,
    method: () -> Unit = {},
    fontWeight: Int = 500,
    passedModifier: Modifier = Modifier
        .background(color = Color.Transparent)
        .fillMaxWidth() // Make the TextField full width
        .padding(horizontal = 20.dp, vertical = 24.dp)
        .border(
            BorderStroke(borderWidth, color), // Blue border with 1dp width
            shape = RoundedCornerShape(8.dp)
        ),
) {
    Column {
        TextField(
            value = "Text",
            onValueChange = { method },
            label = {
                Text("$labelText", fontWeight = FontWeight(fontWeight))
            },
            modifier = passedModifier,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent, // No focused underline color
                unfocusedIndicatorColor = Color.Transparent, // No unfocused underline color
                disabledIndicatorColor = Color.Transparent, // No disabled underline color
                focusedLabelColor = color,
                unfocusedLabelColor = color,
            )
        )
    }
}