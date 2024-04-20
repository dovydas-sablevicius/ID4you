package com.project.id4you.presentation.screens.documentDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.id4you.common.Constants
import com.project.id4you.data.repository.model.Document
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.screens.documentDetail.components.DocumentDetailScreenHeader
import com.project.id4you.presentation.screens.documentDetail.components.ImageSection
import com.project.id4you.presentation.screens.documentDetail.components.InformationSection
import com.project.id4you.presentation.screens.documentDetail.components.StatusText
import java.time.LocalDate

@Composable
fun DocumentDetailScreen(
    state: DocumentDetailState,
    onNavigateToDocumentQrScreen: (String) -> Unit,
) {
    if (state.isSuccess && state.document != null) {
        SuccessScreen(
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
    onNavigateToDocumentQrScreen: (String) -> Unit,
    document: Document
) {
    val imageFetchUrl: String =
        Constants.BASE_URL + "/api/files/" + document.collectionId + "/" + document.id + "/"
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
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
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ImageSection(document, imageFetchUrl)
            InformationSection(
                modifier = Modifier.heightIn(0.dp, screenHeight / 2),
                document = document
            )
            StatusText(valid = document.valid)
        }
        ButtonComponent(
            labelText = "QR Code",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(bottom = 6.dp),
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
                type = "Passport",
                valid = true,
                documentCode = "556456456",
                validUntil = LocalDate.now().toString(),
                documentPhotos = listOf(),
                collectionId = "4564564",
                driverLicenseCategory = listOf()
            )
        )
    ) {}
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    DocumentDetailScreen(
        state = DocumentDetailState(
            isLoading = true
        )
    ) {}
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    DocumentDetailScreen(
        state = DocumentDetailState(
            error = "Big Error"
        )
    ) {}
}
