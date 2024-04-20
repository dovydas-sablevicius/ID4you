package com.project.id4you.presentation.screens.createDocument

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomDropdown
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun CreateDocumentScreen(
    state: CreateDocumentState,
    onEvent: (CreateDocumentEvent) -> Unit,
    //onNavigateToUploadDocument: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            TextComponent(labelText = "Create", textType = TextType.HEADER)
        }

        CustomTextField(
            labelText = "Name...",
            value = state.name,
            onValueChange = { onEvent(CreateDocumentEvent.EnteredName(it)) }
        )

        CustomDropdown(
            labelText = "Select document type",
            items = listOf("Passport", "Driver's License", "ID Card"),
            selectedItem = state.documentType,
            onItemSelected = { onEvent(CreateDocumentEvent.EnteredDocumentType(it)) }
        )

        Spacer(modifier = Modifier.weight(1f))
        ButtonComponent(
            method = { onEvent(CreateDocumentEvent.PressedContinueButton) },
            labelText = "Continue",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp)
                .testTag(TestTags.CONTINUE_BUTTON),
        )
    }

    /*if (state.isSuccess) {
        LaunchedEffect(Unit) {
            onNavigateToUploadDocument()
        }
    }*/
}

