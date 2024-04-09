package com.project.id4you.presentation.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.Test

class TypeTest {
    @Test
    fun returnedCorrectTypography() {
        val expectedFontFamily = FontFamily.Default
        val expectedFontWeight = FontWeight.Normal
        val expectedFontSize = 16.sp
        val expectedLineHeight = 24.sp
        val expectedLetterSpacing = 0.5.sp
        val typography = Typography
        assert(typography.bodyLarge.fontFamily == expectedFontFamily)
        assert(typography.bodyLarge.fontWeight == expectedFontWeight)
        assert(typography.bodyLarge.fontSize == expectedFontSize)
        assert(typography.bodyLarge.lineHeight == expectedLineHeight)
        assert(typography.bodyLarge.letterSpacing == expectedLetterSpacing)
    }
}