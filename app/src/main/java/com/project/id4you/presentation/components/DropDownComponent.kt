package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.ui.theme.AppColor.Companion.Blue

@Composable
fun CustomDropdown(
    modifier: Modifier = Modifier,
    labelText: String,
    items: List<String>,
    selectedItem: String?,
    onItemSelected: (String) -> Unit,
    color: Color = Blue,
    borderWidth: Dp = 1.dp,
    fontFamily: FontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    horizontalPadding: Dp = 20.dp,
    verticalPadding: Dp = 10.dp,
    roundCornerRadius: Dp = 8.dp,
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontalPadding, verticalPadding)
                .border(
                    BorderStroke(borderWidth, color),
                    shape = RoundedCornerShape(roundCornerRadius)
                )
                .clickable { expanded = true }
        ) {
            Text(
                text = selectedItem ?: labelText,
                fontFamily = fontFamily,
                fontStyle = fontStyle,
                fontWeight = fontWeight,
                fontSize = fontSize,
                modifier = Modifier.padding(start = 8.dp, end = 20.dp)
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Arrow",
                tint = color,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
        ) {
            items.forEach { item ->
                DropdownMenuItem(text = { item }, onClick = { onItemSelected(item) })
            }
        }
    }
}
