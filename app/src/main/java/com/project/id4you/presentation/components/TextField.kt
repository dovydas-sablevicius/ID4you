package com.project.id4you.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.ui.theme.Color.Companion.Blue

@Suppress("LongParameterList")
@Composable
fun CustomTextField(
    labelText: String,
    isPasswordField: Boolean = false,
    color: Color = Blue,
    borderWidth: Dp = 1.dp,
    fontFamily: SystemFontFamily = FontFamily.Default,
    fontStyle: FontStyle = FontStyle.Normal,
    fontSize: TextUnit = 12.sp,
    fontWeight: Int = 500,
    horizontalPadding: Dp = 20.dp,
    verticalPadding: Dp = 10.dp,
    roundCornerRadius: Dp = 8.dp,
) {
    val (isPasswordVisible, setPasswordVisible) = remember { mutableStateOf(!isPasswordField) }
    val (inputValue, setInputValue) = remember { mutableStateOf(TextFieldValue()) }

    Box() {
        TextField(
            value = inputValue,
            onValueChange = { newValue -> setInputValue(newValue) },
            label = {
                Text(
                    text = labelText,
                    fontFamily = fontFamily,
                    fontStyle = fontStyle,
                    fontWeight = FontWeight(fontWeight),
                    fontSize = fontSize
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontalPadding, verticalPadding)
                .border(
                    BorderStroke(borderWidth, color),
                    shape = RoundedCornerShape(roundCornerRadius)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent, // No focused underline color
                unfocusedIndicatorColor = Color.Transparent, // No unfocused underline color
                disabledIndicatorColor = Color.Transparent, // No disabled underline color
                focusedLabelColor = color,
                unfocusedLabelColor = color,
            ),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        )
        if (isPasswordField) {
            Button(
                onClick = { setPasswordVisible(!isPasswordVisible) },
                colors = ButtonDefaults.buttonColors(
                    contentColor = color,
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .padding(start = 4.dp, top = 15.dp, end = 24.dp)
                    .align(Alignment.TopEnd)
                //.offset(x = (300).dp, y = 20.dp)
            ) {
                Text(
                    text = if (isPasswordVisible) "Hide" else "Show",
                    fontFamily = fontFamily,
                    fontStyle = fontStyle,
                    fontWeight = FontWeight(fontWeight),
                    fontSize = fontSize
                )
            }
        }
    }
}
