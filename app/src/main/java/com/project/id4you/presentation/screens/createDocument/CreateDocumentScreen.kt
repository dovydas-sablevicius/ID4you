package com.project.id4you.presentation.screens.createDocument

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomDropdown
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun CreateDocumentScreen(
    state: CreateDocumentState,
    onEvent: (CreateDocumentEvent) -> Unit,
    onNavigateToUploadDocumentFront: (String, String) -> Unit
) {
    val errorMessage = "You must fill all empty fields."
    val buttonColor = if (state.name.isBlank() || state.documentType.isBlank()) {
        AppColor.DisabledBlue
    } else {
        AppColor.Blue
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(TestTags.DOCUMENT_CREATION_SCREEN),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {

            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                TextComponent(labelText = "Create", textType = TextType.HEADER)
            }

            CustomTextField(
                labelText = "Name...",
                value = state.name,
                onValueChange = { onEvent(CreateDocumentEvent.EnteredName(it)) },
                modifier = Modifier.testTag(TestTags.DOCUMENT_CREATION_SCREEN_NAME_FIELD)
            )

            CustomDropdown(
                labelText = "Select document type",
                items = listOf("Passport", "Driver's License", "ID Card"),
                selectedItem = state.documentType,
                onItemSelected = { onEvent(CreateDocumentEvent.EnteredDocumentType(it)) },
                modifier = Modifier.testTag(TestTags.DROPDOWN_FIELD)
            )
        }

        if (state.error.isNotBlank()) {
            ErrorText(errorMessage = errorMessage, modifier = Modifier.size(500.dp))
        }

        ButtonComponent(
            method = {
                if (state.name.isNotBlank() && state.documentType.isNotBlank()) {
                    onNavigateToUploadDocumentFront(state.name, state.documentType)
                } else {
                    onEvent(CreateDocumentEvent.PressedContinueButton)
                }
            },
            labelText = "Continue",
            textColor = AppColor.White,
            buttonColor = buttonColor,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp)
                .testTag(TestTags.CONTINUE_BUTTON),
        )
    }
}



