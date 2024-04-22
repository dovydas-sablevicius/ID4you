package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.R
import com.project.id4you.data.repository.model.DocumentStatus


@Suppress("LongParameterList")
@Composable
fun CardComponent(
    documentName: String,
    documentType: String,
    documentStatus: DocumentStatus,
    backgroundColor: Color = Color.White,
    documentNameColor: Color = Color.Black,
    documentTypeColor: Color = Color.Gray,
    iconColor: Color = Color.Black,
    modifier: Modifier = Modifier,
    method: () -> Unit = {}
) {
    Surface(
        tonalElevation = 20.dp,
        shadowElevation = 10.dp,
        shape = RoundedCornerShape(8.dp),
        color = Color.Transparent
    ) {
        Button(
            onClick = method,
            modifier = modifier
                .height(100.dp)
                .width(360.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(0.dp, color = Color.Gray.copy(alpha = 0.7f))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.document_icon),
                    tint = iconColor,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )

                Column(
                ) {
                    Text(
                        text = documentName,
                        color = documentNameColor,
                        fontSize = 18.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.width(100.dp)
                    )
                    Text(text = documentType, color = documentTypeColor, fontSize = 12.sp)
                }

                Text(
                    text = documentStatus.name,
                    color = documentNameColor,
                    fontSize = 16.sp,
                    modifier = Modifier.offset(x = 20.dp)
                )
                DocumentIcon(documentStatus)

            }
        }
    }
}

@Composable
fun DocumentIcon(documentStatus: DocumentStatus) {

    val iconPainter: Painter
    val iconTint: Color

    when (documentStatus) {
        DocumentStatus.VERIFIED -> {
            iconPainter = painterResource(id = R.drawable.check_circle)
            iconTint = Color.Green
        }

        DocumentStatus.PENDING -> {
            iconPainter = painterResource(id = R.drawable.clock_icon)
            iconTint = Color.Yellow
        }

        DocumentStatus.REJECTED -> {
            iconPainter = painterResource(id = R.drawable.rejected_icon)
            iconTint = Color.Red
        }
    }

    Icon(
        painter = iconPainter,
        tint = iconTint,
        contentDescription = null,
        modifier = Modifier
            .size(30.dp)
            .offset(x = 10.dp)
    )
}
