package com.project.id4you.presentation.components.text

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

enum class TextType(val textStyle: TextStyle) {
    HEADER(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
            fontWeight = FontWeight(500)
        )
    ),
    CLICKABLE(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 15.sp,
            fontWeight = FontWeight(500)
        )
    ),
    REGULAR(TextStyle(/* define your regular text style */)),
    ERROR(TextStyle(/* define your error text style */)),
    DATA(TextStyle(/* define your data text style */));

}