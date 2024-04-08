package com.project.id4you.presentation.screens.documentQr

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.screens.documentQr.Constants.QR_CODE_HEIGHT

@Composable
fun DocumentQrScreen(
    state: DocumentQrState,
    onEvent: (DocumentQrEvent) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextComponent(labelText = "Document QR Code", textType = TextType.HEADER)

        Spacer(modifier = Modifier.weight(1f))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextComponent(
                labelText = "Scan QR Code to see document details",
                textType = TextType.REGULAR
            )

            if (state.documentId.isEmpty()) {
                Text(text = "Error: Document ID not found")
            } else {
                state.documentQrCode?.let { qrCode ->
                    Image(
                        bitmap = qrCode.asImageBitmap(),
                        contentDescription = "Document QR Code",
                        modifier = Modifier.size(QR_CODE_HEIGHT.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }

            TextComponent(
                labelText = "Time remaining: ${state.qrCodeRemainingTime} seconds",
                textType = TextType.SMALL
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        ButtonComponent(
            labelText = "Regenerate QR Code",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp),
            method = {
                onEvent(DocumentQrEvent.RegenerateQrCode)
            }
        )

    }
}
