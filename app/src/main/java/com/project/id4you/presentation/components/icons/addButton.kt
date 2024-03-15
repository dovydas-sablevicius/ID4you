package com.project.id4you.presentation.components.icons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun addButton(
    size: Dp = 30.dp,
    color: Color = Color.Blue,
    method: () -> Unit = {}
) {
    IconButton(onClick = { method }) {
        Icon(
            imageVector = Icons.Outlined.Add,
            tint = color,
            contentDescription = "Add",
            modifier = Modifier.size(size)
        )
    }
}
