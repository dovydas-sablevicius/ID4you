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
import com.project.id4you.data.repository.model.Document
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.screens.documentDetail.components.AttributeInformation
import com.project.id4you.presentation.screens.documentDetail.components.DocumentDetailScreenHeader
import java.time.LocalDate

@Composable
fun DocumentDetailScreen(
    state: DocumentDetailState,
    onNavigateToDocumentQrScreen: (String) -> Unit,
    onNavigateBackToDocumentList: () -> Unit,
) {
    if (state.isSuccess && state.document != null) {
        SuccessScreen(
            onNavigateBackToDocumentList,
            onNavigateToDocumentQrScreen,
            state.document
        )
        return
    }
    if (state.error != "") {
        ErrorScreen(state.error)
        return
    }
    LoadingScreen()
    return
}

@Composable
private fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextComponent(labelText = "Loading...", textType = TextType.HEADER)
    }
}

@Composable
private fun ErrorScreen(errorMessage: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextComponent(labelText = errorMessage, textType = TextType.HEADER)
    }
}

@Composable
private fun SuccessScreen(
    onNavigateBackToDocumentList: () -> Unit,
    onNavigateToDocumentQrScreen: (String) -> Unit,
    document: Document
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DocumentDetailScreenHeader(
            navigateBack = onNavigateBackToDocumentList,
            headerText = document.name
        )
        Column(
            modifier = Modifier.padding(26.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AttributeInformation(attributeName = "Document Name", attributeValue = document.name)
            AttributeInformation(
                attributeName = "Created",
                attributeValue = document.created,
                valueWeight = 3f
            )
            AttributeInformation(
                attributeName = "Updated",
                attributeValue = document.updated,
                valueWeight = 3f
            )
        }

        ButtonComponent(
            labelText = "QR Code",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp),
            method = {
                onNavigateToDocumentQrScreen(document.id)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {
    DocumentDetailScreen(
        state = DocumentDetailState(
            isSuccess = true,
            document = Document(
                id = "1",
                name = "Document Name",
                created = LocalDate.now().toString(),
                updated = LocalDate.now().toString()
            )
        ),
        onNavigateToDocumentQrScreen = {},
        onNavigateBackToDocumentList = {})
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    DocumentDetailScreen(
        state = DocumentDetailState(
            isLoading = true
        ),
        onNavigateToDocumentQrScreen = {},
        onNavigateBackToDocumentList = {})
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    DocumentDetailScreen(
        state = DocumentDetailState(
            error = "Big Error"
        ),
        onNavigateToDocumentQrScreen = {},
        onNavigateBackToDocumentList = {})
}