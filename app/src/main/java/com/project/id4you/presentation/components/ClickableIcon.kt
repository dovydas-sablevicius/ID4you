package com.project.id4you.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.ui.theme.AppColor

@Suppress("LongParameterList", "TooGenericExceptionThrown")
@Composable
fun ClickableIcon(
    size: Dp = 30.dp,
    color: Color = AppColor.Blue,
    method: () -> Unit = {},
    imageVector: ImageVector? = null,
    painterId: Int? = null
) {
    IconButton(
        onClick = method,
        modifier = Modifier.size(size)
    ) {
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                tint = color,
                contentDescription = "Add",
                modifier = Modifier.size(size)
            )
        } else if (painterId != null) {
            Icon(
                painter = painterResource(id = painterId),
                tint = color,
                contentDescription = "Add",
                modifier = Modifier.size(size)
            )
        } else {
            throw Exception("No Icon For ClickableIcon")
        }
    }
}
