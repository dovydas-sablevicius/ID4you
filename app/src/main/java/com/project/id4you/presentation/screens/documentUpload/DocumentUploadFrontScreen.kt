package com.project.id4you.presentation.screens.documentUpload

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun DocumentUploadFrontScreen(
    /*state: DocumentUploadFrontState,
    onNavigateToUploadDocumentFrontPreview: () -> Unit*/
) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Spacer(modifier = Modifier.height(20.dp))
            TextComponent(labelText = "Capture document", textType = TextType.HEADER)

            Spacer(modifier = Modifier.weight(1f))
            ButtonComponent(
                method = { /*onNavigateToUploadDocumentFrontPreview()*/ },
                labelText = "Take Photo",
                textColor = Color.White,
                buttonColor = Color.Blue,
                modifier = Modifier
                    .width(350.dp)
                    .padding(vertical = 16.dp)
            )
        }
    }
}