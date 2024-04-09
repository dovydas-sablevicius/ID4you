package com.project.id4you.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import org.junit.Test

class AppColorTest {
    @Test
    fun returnRedColor() {
        val expectedColor = Color(0xFFEE0000)
        val returnedColor = AppColor.Red
        assert(expectedColor == returnedColor)
    }

    @Test
    fun returnBlackColor() {
        val expectedColor = Color(0xFF000000)
        val returnedColor = AppColor.Black
        assert(expectedColor == returnedColor)
    }

    @Test
    fun returnWhiteColor() {
        val expectedColor = Color(0xFFFFFFFF)
        val returnedColor = AppColor.White
        assert(expectedColor == returnedColor)
    }

    @Test
    fun returnBlueColor() {
        val expectedColor = Color(0xFF404CFA)
        val returnedColor = AppColor.Blue
        assert(expectedColor == returnedColor)
    }

    @Test
    fun returnDisabledBlueColor() {
        val expectedColor = Color(0xFF8189FF)
        val returnedColor = AppColor.DisabledBlue
        assert(expectedColor == returnedColor)
    }
}