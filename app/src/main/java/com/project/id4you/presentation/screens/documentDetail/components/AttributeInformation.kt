package com.project.id4you.presentation.screens.documentDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun AttributeInformation(
    modifier: Modifier = Modifier,
    attributeName: String,
    attributeValue: String,
    textColor: Color = AppColor.Blue,
    dividerColor: Color = AppColor.Blue,
    valueWeight: Float = 1f
) {
    Column(
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp),
        ) {
            Text(
                text = attributeName,
                color = textColor,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = attributeValue,
                color = textColor,
                textAlign = TextAlign.End,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(valueWeight)
            )
        }
        HorizontalDivider(color = dividerColor, thickness = 3.dp)
    }


}
