package com.project.id4you.presentation.screens.documentDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.screens.documentDetail.components.AttributeInformation
import com.project.id4you.presentation.screens.documentDetail.components.Header

@Composable
fun DocumentDetailScreen(
    state: DocumentDetailState,
    onNavigateToDocumentQrScreen: (String) -> Unit,
    onNavigateBackToDocumentList: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(navigateBack = onNavigateBackToDocumentList)
        Column(
            modifier = Modifier.padding(26.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AttributeInformation(attributeName = "Test", attributeValue = "TTest")
            AttributeInformation(attributeName = "Test", attributeValue = "TTest")
            AttributeInformation(attributeName = "Test", attributeValue = "TTest")
            AttributeInformation(attributeName = "Test", attributeValue = "TTest")
        }

        ButtonComponent(
            labelText = "QR Code",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp),
            method = {
                onNavigateToDocumentQrScreen(state.documentId)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun test() {
    DocumentDetailScreen(
        state = DocumentDetailState(),
        onNavigateToDocumentQrScreen = {},
        onNavigateBackToDocumentList = {})
}
