package com.project.id4you.presentation.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    labelText: String,
    textType: TextType,
    color: Color = AppColor.Black,
    ) {
    val textStyle = textType.textStyle

    Text(
        text = labelText,
        style = textStyle,
        color = color,
        modifier = modifier
    )
}
