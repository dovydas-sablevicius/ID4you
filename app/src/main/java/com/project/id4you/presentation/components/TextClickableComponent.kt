package com.project.id4you.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.ui.theme.Color.Companion.Blue

@Suppress("LongParameterList")
@Composable
fun TextClickableComponent(
    labelText: String,
    textColor: Color = Blue,
    backgroundColor: Color = Color.Transparent,
    fontFamily: SystemFontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: Int = 400,
    method: () -> Unit = {}
) {
    Button(
        onClick = method,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = backgroundColor
        ),
    ) {
        Text(
            text = labelText,
            fontFamily = fontFamily,
            fontStyle = fontStyle,
            fontWeight = FontWeight(fontWeight),
            fontSize = fontSize
        )
    }
}
