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
import androidx.compose.ui.unit.dp
import com.project.id4you.common.Constants
import com.project.id4you.data.repository.model.Document
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.screens.documentDetail.components.DocumentDetailScreenHeader
import com.project.id4you.presentation.screens.documentDetail.components.ImageSection
import com.project.id4you.presentation.screens.documentDetail.components.InformationSection
import com.project.id4you.presentation.screens.documentDetail.components.StatusText

@Composable
fun DocumentDetailScreen(
    state: DocumentDetailState,
    onNavigateToDocumentQrScreen: (String) -> Unit,
    onNavigateToDocumentQrScanScreen: () -> Unit,
) {
    if (state.isSuccess && state.document != null) {
        SuccessScreen(
            onNavigateToDocumentQrScreen,
            onNavigateToDocumentQrScanScreen,
            state.document,
            state
        )
        return
    }
    if (state.error != "") {
        ErrorScreen(state.error)
        return
    }
    LoadingScreen()
}

@Composable
private fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadingIndicator()
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

@Suppress("MagicNumber")
@Composable
private fun SuccessScreen(
    onNavigateToDocumentQrScreen: (String) -> Unit,
    onNavigateToDocumentQrScanScreen: () -> Unit,
    document: Document,
    state: DocumentDetailState,
) {
    val imageFetchUrl: String =
        Constants.BASE_URL + "/api/files/" + document.collectionId + "/" + document.id + "/"

    val labelText = if (state.isScanned) "Scan" else "QR Code"
    val onClickMethod: () -> Unit = if (state.isScanned) {
        onNavigateToDocumentQrScanScreen
    } else {
        { onNavigateToDocumentQrScreen(document.id) }
    }


    val columnWeight: Float = 5f
    val buttonWeight: Float = 1f
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DocumentDetailScreenHeader(
            headerText = document.name
        )
        Column(
            modifier = Modifier
                .padding(14.dp)
                .weight(columnWeight),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ImageSection(document, imageFetchUrl)
            InformationSection(
                document = document
            )
            StatusText(valid = document.valid)
        }
        ButtonComponent(
            labelText = labelText,
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp)
                .weight(buttonWeight, false),
            method = onClickMethod
        )
    }
}


