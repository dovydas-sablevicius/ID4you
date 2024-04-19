package com.project.id4you.presentation.screens.documentsList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.R
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ClickableIcon
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
        ClickableIcon(size = 35.dp, imageVector = Icons.Outlined.Add)
        Spacer(modifier = Modifier.width(32.dp))
        TextComponent(
            labelText = "Documents",
            textType = TextType.HEADER,
            modifier = Modifier.Companion.testTag(TestTags.DOCUMENT_QR_HEADER)
        )
        ClickableIcon(painterId = R.drawable.baseline_tune_24)
        ClickableIcon(imageVector = Icons.Outlined.Settings)
    }
    Spacer(modifier = Modifier.height(10.dp))
}
