package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardComponent(
    documentName: String,
    documentType: String,
    documentStatus: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier,
    method: () -> Unit = {},
    fontFamily: FontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Button(
        onClick = method,
        modifier = modifier
            .height(100.dp)
            .width(300.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
        ),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
            ) {
                Text(text = documentName)
                Text(text = documentType)
            }
            Text(text = documentStatus)
        }
    }
}
