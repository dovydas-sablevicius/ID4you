package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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


enum class DocumentStatus {
    VERIFIED, PENDING, REJECTED
}

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
    Button(
        onClick = method,
        modifier = modifier
            .height(100.dp)
            .width(350.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Black)
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

            Text(text = documentStatus.name, color = documentNameColor, fontSize = 16.sp)

            DocumentIcon(documentStatus)

        }
    }
}

@Composable
fun DocumentIcon(documentStatus: DocumentStatus) {

    var iconPainter: Painter
    var iconTint: Color

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
        modifier = Modifier.size(30.dp)
    )
}
