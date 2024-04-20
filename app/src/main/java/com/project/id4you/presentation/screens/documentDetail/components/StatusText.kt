package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun StatusText(valid: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        TextComponent(labelText = "Status: ", textType = TextType.REGULAR)
        if (valid) {
            TextComponent(
                labelText = "Valid",
                textType = TextType.REGULAR,
                color = AppColor.Green
            )
        } else {
            TextComponent(
                labelText = "Invalid",
                textType = TextType.REGULAR,
                color = AppColor.Red
            )
        }
    }
}