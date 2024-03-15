package com.project.id4you.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.ui.theme.Blue


@Composable
fun TextClickableComponent(
    labelText: String,
    textColor: Color = Blue,
    backgroundColor: Color = Color.Transparent,
    fontFamily: SystemFontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: Int = 500,
    method: () -> Unit = {},
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
}

