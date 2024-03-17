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
fun RegistrationScreen() {


    val inputStateEmail = remember { mutableStateOf(TextFieldValue()) }
    val (inputValueEmail, setInputValueEmail) = inputStateEmail

    val inputStatePassword = remember { mutableStateOf(TextFieldValue()) }
    val (inputValuePassword, setInputValuePassword) = inputStatePassword

    val inputStateName = remember { mutableStateOf(TextFieldValue()) }
    val (inputValueName, setInputValueName) = inputStateName


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        ScreenHeader(headerText = "Sign Up", buttonText = "Login")
        CustomTextField(
            labelText = "Name",
            inputState = inputStateName
        )
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
            labelText = "Sign Up",
            Color.White,
            Color.Blue,
        )
    }

}


@Composable
fun ScreenHeader(
    headerText: String,
    buttonText: String
) {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.Right,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextComponent(
            labelText = headerText,
            fontWeight = 500,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.width(64.dp))
        TextClickableComponent(
            labelText = buttonText,
            fontWeight = 500,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

