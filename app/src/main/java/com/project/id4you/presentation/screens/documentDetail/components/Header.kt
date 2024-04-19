package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.id4you.R
import com.project.id4you.presentation.components.ClickableIcon
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun Header(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            ClickableIcon(painterId = R.drawable.outline_arrow_back_24, method = navigateBack)
        }
        Box(
            modifier = Modifier
                .weight(2f)
        )
        {
            TextComponent(labelText = "Document Name", textType = TextType.HEADER)
        }
    }
}