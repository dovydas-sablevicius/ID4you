package com.project.id4you.presentation.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import org.junit.Test

class ThemeTest {
    @Test
    fun returnDarkAppColorTheme() {
        val expectedPrimary = AppColor.White
        val expectedSecondary = AppColor.Blue
        val expectedTertiary = AppColor.Black
        val theme = DarkAppColorScheme
        testTheme(theme, expectedPrimary, expectedSecondary, expectedTertiary)
    }

    @Test
    fun returnLightAppColorTheme() {
        val expectedPrimary = AppColor.White
        val expectedSecondary = AppColor.Blue
        val expectedTertiary = AppColor.Black
        val theme = LightAppColorScheme
        testTheme(theme, expectedPrimary, expectedSecondary, expectedTertiary)
    }

    private fun testTheme(
        theme: ColorScheme,
        expectedPrimary: Color,
        expectedSecondary: Color,
        expectedTertiary: Color
    ) {
        assert(theme.primary == expectedPrimary)
        assert(theme.secondary == expectedSecondary)
        assert(theme.tertiary == expectedTertiary)
    }

}