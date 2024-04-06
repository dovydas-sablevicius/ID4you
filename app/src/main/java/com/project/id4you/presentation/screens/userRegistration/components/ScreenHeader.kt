package com.project.id4you.presentation.screens.userRegistration.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.text.TextClickableComponent
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun ScreenHeader(
    headerText: String,
    buttonText: String,
    onNavigateToLogin: () -> Unit
) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Right,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextComponent(labelText = headerText, textType = TextType.HEADER)
        Spacer(modifier = Modifier.width(64.dp))
        TextClickableComponent(
            onClick = { onNavigateToLogin() },
            labelText = buttonText,
            textType = TextType.CLICKABLE
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}
