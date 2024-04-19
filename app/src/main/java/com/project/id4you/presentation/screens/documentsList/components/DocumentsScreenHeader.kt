package com.project.id4you.presentation.screens.documentsList.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
fun DocumentScreenHeader(
    modifier: Modifier = Modifier,
    method: () -> Unit
) {
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp, 2.dp), contentAlignment = Alignment.CenterStart
    )
    {
        ClickableIcon(size = 35.dp, imageVector = Icons.Outlined.Add, method = method)
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd)
        {
            Row {
                ClickableIcon(painterId = R.drawable.baseline_tune_24)
                Spacer(modifier = Modifier.padding(5.dp))
                ClickableIcon(imageVector = Icons.Outlined.Settings)
            }
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center)
            {
                TextComponent(
                    labelText = "Documents",
                    textType = TextType.HEADER,
                    modifier = Modifier.Companion.testTag(TestTags.DOCUMENT_QR_HEADER)
                )
            }

        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

