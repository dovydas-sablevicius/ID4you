package com.project.id4you.presentation.components.text

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.junit.Test

class TextTypeTest {
    @Test
    fun returnCorrectHeaderStyle() {
        val expectedFontFamily = FontFamily.Default
        val expectedFontStyle = FontStyle.Normal
        val expectedFontSize = 32.sp
        val expectedFontWeight = FontWeight(400)
        val textStyle = TextType.HEADER.textStyle
        testStyle(
            textStyle,
            expectedFontStyle,
            expectedFontWeight,
            expectedFontSize,
            expectedFontFamily
        )
    }

    @Test
    fun returnCorrectClickableStyle() {
        val expectedFontFamily = FontFamily.Default
        val expectedFontStyle = FontStyle.Normal
        val expectedFontSize = 15.sp
        val expectedFontWeight = FontWeight(400)
        val textStyle = TextType.CLICKABLE.textStyle

        testStyle(
            textStyle,
            expectedFontStyle,
            expectedFontWeight,
            expectedFontSize,
            expectedFontFamily
        )
    }

    @Test
    fun returnCorrectRegularStyle() {
        val expectedFontFamily = FontFamily.Default
        val expectedFontStyle = FontStyle.Normal
        val expectedFontSize = 20.sp
        val expectedFontWeight = FontWeight(500)
        val textStyle = TextType.REGULAR.textStyle

        testStyle(
            textStyle,
            expectedFontStyle,
            expectedFontWeight,
            expectedFontSize,
            expectedFontFamily
        )
    }

    @Test
    fun returnCorrectSmallStyle() {
        val expectedFontFamily = FontFamily.Default
        val expectedFontStyle = FontStyle.Normal
        val expectedFontSize = 17.sp
        val expectedFontWeight = FontWeight(400)
        val textStyle = TextType.SMALL.textStyle

        testStyle(
            textStyle,
            expectedFontStyle,
            expectedFontWeight,
            expectedFontSize,
            expectedFontFamily
        )
    }

    private fun testStyle(
        textStyle: TextStyle,
        expectedFontStyle: FontStyle,
        expectedFontWeight: FontWeight,
        expectedFontSize: TextUnit,
        expectedFontFamily: SystemFontFamily
    ) {
        assert(textStyle.fontStyle == expectedFontStyle)
        assert(textStyle.fontWeight == expectedFontWeight)
        assert(textStyle.fontSize == expectedFontSize)
        assert(textStyle.fontFamily == expectedFontFamily)
    }
}