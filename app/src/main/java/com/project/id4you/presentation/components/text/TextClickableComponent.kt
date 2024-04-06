package com.project.id4you.presentation.components.text

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.project.id4you.presentation.ui.theme.AppColor.Companion.Blue

@Suppress("LongParameterList")
@Composable
fun TextClickableComponent(
    textColor: Color = Blue,
    backgroundColor: Color = Color.Transparent,
    onClick: () -> Unit = {},
    labelText: String,
    textType: TextType
) {
    val textStyle = textType.textStyle

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor,
            containerColor = backgroundColor
        ),
    ) {
        Text(
            text = labelText,
            style = textStyle
        )
    }
}
