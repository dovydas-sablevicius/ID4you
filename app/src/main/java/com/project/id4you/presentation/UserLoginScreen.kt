package com.project.id4you.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.TextClickableComponent
import com.project.id4you.presentation.components.TextComponent
import com.project.id4you.presentation.ui.theme.Color

@Composable
fun UserLoginScreen(

) {
    val inputStateEmail = remember { mutableStateOf(TextFieldValue()) }
    val (inputValueEmail, setInputValueEmail) = inputStateEmail

    val inputStatePassword = remember { mutableStateOf(TextFieldValue()) }
    val (inputValuePassword, setInputValuePassword) = inputStatePassword

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        ScreenHeader()
        CustomTextField(
            labelText = "Email",
            inputState = inputStateEmail
        )
        CustomTextField(
            labelText = "Password",
            inputState = inputStatePassword,
            isPasswordField = true
        )
        ButtonComponent(
            Modifier.width(375.dp),
            labelText = "Login",
            Color.White,
            Color.Blue
        )
        TextClickableComponent(
            labelText = "Forgot your password?",
            fontWeight = 500,
            fontSize = 12.sp
        )
    }
}

@Composable
fun ScreenHeader() {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Right,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextComponent(
            labelText = "Login",
            fontWeight = 500,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.width(64.dp))
        TextClickableComponent(
            labelText = "Sign Up",
            fontWeight = 500,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}
