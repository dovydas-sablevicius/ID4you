package com.project.id4you.presentation.screens.documentsList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.data.repository.model.DocumentStatus
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CardComponent
import com.project.id4you.presentation.screens.documentsList.components.DocumentScreenHeader

@Composable
fun UserDocumentPageScreen(
    state: DocumentsListState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.testTag(TestTags.DOCUMENT_LIST_SCREEN)
    ) {

        DocumentScreenHeader()

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(state.documents) { document ->
                CardComponent(
                    documentName = document.name,
                    documentType = "ID Card",
                    documentStatus = DocumentStatus.VERIFIED
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        ButtonComponent(
            labelText = "Scan",
            textColor = Color.White,
            buttonColor = Color.Blue,
            modifier = Modifier
                .width(350.dp)
                .padding(vertical = 16.dp),
        )
    }
}

