package com.project.id4you.presentation.components.text

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

const val DEFAULT_FONT_WEIGHT = 400;
const val REGULAR_FONT_WEIGHT = 500;

enum class TextType(val textStyle: TextStyle) {
    HEADER(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
            fontWeight = FontWeight(DEFAULT_FONT_WEIGHT)
        )
    ),
    HEADER_WHITE(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 32.sp,
            fontWeight = FontWeight(DEFAULT_FONT_WEIGHT),
            color = Color.White
        )
    ),
    CLICKABLE(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 15.sp,
            fontWeight = FontWeight(DEFAULT_FONT_WEIGHT)
        )
    ),
    REGULAR(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp,
            fontWeight = FontWeight(REGULAR_FONT_WEIGHT)
        )
    ),
    SMALL(
        TextStyle(
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontSize = 17.sp,
            fontWeight = FontWeight(DEFAULT_FONT_WEIGHT)
        )
    ),
    ERROR(TextStyle(/* define your error text style */)),
    DATA(TextStyle(/* define your data text style */));

}
