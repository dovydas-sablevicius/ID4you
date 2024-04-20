package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun DocumentDetailScreenHeader(
    modifier: Modifier = Modifier,
    headerText: String,
) {
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center)
    {
        TextComponent(labelText = headerText, textType = TextType.HEADER)
    }

}
