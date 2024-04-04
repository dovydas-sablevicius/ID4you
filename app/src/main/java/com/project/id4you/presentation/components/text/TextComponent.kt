package com.project.id4you.presentation.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun TextComponent(
    labelText: String,
    textType: TextType
) {
    val textStyle = textType.textStyle

    Text(
        text = labelText,
        style = textStyle
    )
}
