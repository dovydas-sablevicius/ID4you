package com.project.id4you.presentation.components.icons


import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.id4you.R


@Composable
fun filterButton(
    size: Dp = 30.dp,
    color: Color = Color.Blue,
    method: () -> Unit = {}
) {
    IconButton(onClick = { method }) {
        Icon(
            modifier = Modifier.size(size),
            painter = painterResource(id = R.drawable.baseline_tune_24),
            contentDescription = null,
            tint = color
        )
    }
}
