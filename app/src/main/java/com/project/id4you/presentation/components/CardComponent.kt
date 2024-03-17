package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.R

@Composable
fun CardComponent(
    documentName: String,
    documentType: String,
    documentStatus: String,
    backgroundColor: Color = Color.White,
    statusIconColor: Color,
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
            .width(300.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
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
                modifier = Modifier.size(44.dp)
            )

            Column(
            ) {

                Text(text = documentName, color = documentNameColor, fontSize = 18.sp)
                Text(text = documentType, color = documentTypeColor, fontSize = 12.sp)
            }

            Text(text = documentStatus, color = documentNameColor, fontSize = 18.sp)

            when (documentStatus) {
                "Pending" -> {
                    Icon(
                        painter = painterResource(id = R.drawable.clock_icon),
                        tint = statusIconColor,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }

                "Verified" -> {
                    Icon(
                        imageVector = Icons.Outlined.CheckCircle,
                        tint = statusIconColor,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }

                "Rejected" -> {
                    Icon(
                        painter = painterResource(id = R.drawable.rejected_icon),
                        tint = statusIconColor,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}
