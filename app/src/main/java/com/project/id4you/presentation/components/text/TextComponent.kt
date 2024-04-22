package com.project.id4you.presentation.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    labelText: String,
    textType: TextType,
) {
    val textStyle = textType.textStyle

    Text(
        text = labelText,
        style = textStyle,
        modifier = modifier
    )
}
