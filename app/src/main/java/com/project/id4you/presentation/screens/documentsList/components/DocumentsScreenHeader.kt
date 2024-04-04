package com.project.id4you.presentation.screens.documentsList.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.components.icons.AddButton
import com.project.id4you.presentation.components.icons.FilterButton
import com.project.id4you.presentation.components.icons.SettingsButton

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
