package com.project.id4you.presentation.screens.documentsList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.icons.AddButton
import com.project.id4you.presentation.components.icons.FilterButton
import com.project.id4you.presentation.components.icons.SettingsButton
import com.project.id4you.presentation.components.text.TextComponent
import com.project.id4you.presentation.components.text.TextType

@Composable
fun DocumentScreenHeader(modifier: Modifier = Modifier) {
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()
    ) {
        AddButton(size = 35.dp)
        Spacer(modifier = Modifier.width(32.dp))
        TextComponent(
            labelText = "Documents",
            textType = TextType.HEADER,
            modifier = Modifier.Companion.testTag(TestTags.DOCUMENT_QR_HEADER)
        )
        FilterButton()
        SettingsButton()
    }
    Spacer(modifier = Modifier.height(10.dp))
}
