package com.project.id4you.presentation.documentsList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.data.repository.model.DocumentStatus
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CardComponent
import com.project.id4you.presentation.components.icons.AddButton
import com.project.id4you.presentation.components.icons.FilterButton
import com.project.id4you.presentation.components.icons.SettingsButton

@Composable
fun UserDocumentPageScreen(
    state: DocumentsListState
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
        //modifier = Modifier.verticalScroll()
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

@Composable
fun DocumentScreenHeader() {

    Spacer(modifier = Modifier.height(20.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        AddButton(size = 35.dp)
        Spacer(modifier = Modifier.width(32.dp))
        Text(text = "Documents", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        FilterButton()
        SettingsButton()
    }
    Spacer(modifier = Modifier.height(10.dp))
}

