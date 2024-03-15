package com.project.id4you.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    labelText: String,
    fontFamily: SystemFontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: Int = 500,
) {
    Text(
        text = labelText,
        fontFamily = fontFamily,
        fontStyle = fontStyle,
        fontWeight = FontWeight(fontWeight),
        fontSize = fontSize
    )
}
