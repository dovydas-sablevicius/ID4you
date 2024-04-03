package com.project.id4you.presentation.userRegistration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.TextClickableComponent
import com.project.id4you.presentation.components.TextComponent
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun RegistrationScreen(
    viewModel: UserRegistrationViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit
) {
    val state = viewModel.state.value
    val errorMessage = "Oops.. An unexpected error occurred."

    val emailInputState = remember { mutableStateOf(TextFieldValue()) }
    val (emailInputValue, setEmailInputValue) = emailInputState

    val passwordInputState = remember { mutableStateOf(TextFieldValue()) }
    val (passwordInputValue, setPasswordInputValue) = passwordInputState

    val passwordRepeatInputState = remember { mutableStateOf(TextFieldValue()) }
    val (passwordRepeatInputValue, setPasswordRepeatInputValue) = passwordRepeatInputState

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        ScreenHeader(
            headerText = "Sign Up",
            buttonText = "Login",
            onNavigateToLogin = onNavigateToLogin
        )
        CustomTextField(
            labelText = "Email",
            inputState = emailInputState
        )
        CustomTextField(
            labelText = "Password",
            inputState = passwordInputState,
            isPasswordField = true
        )
        CustomTextField(
            labelText = "Repeat Password",
            inputState = passwordRepeatInputState,
            isPasswordField = true
        )
        ButtonComponent(
            modifier = Modifier.width(375.dp),
            labelText = "Sign Up",
            method = {
                registerUser(
                    viewModel,
                    emailInputValue,
                    passwordInputValue,
                    passwordRepeatInputValue
                )
            },
            textColor = AppColor.White,
            buttonColor = AppColor.Blue
        )
        if (state.error.isNotBlank()) {
            ErrorText(errorMessage = errorMessage)
        }
        LoadingState(state = state)
    }

    if (state.isSuccess) {
        LaunchedEffect(Unit) {
            onNavigateToLogin()
        }
    }
}

@Composable
fun LoadingState(state: UserRegistrationState) {
    if (state.isLoading) {
        LoadingIndicator()
    }
}

@Composable
fun ScreenHeader(
    headerText: String,
    buttonText: String,
    onNavigateToLogin: () -> Unit
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
            method = { onNavigateToLogin() },
            labelText = buttonText,
            fontWeight = 500,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

fun registerUser(
    viewModel: UserRegistrationViewModel,
    emailValue: TextFieldValue,
    passwordValue: TextFieldValue,
    passwordRepeatValue: TextFieldValue
) {
    viewModel.registerUser(
        emailValue.text,
        passwordValue.text,
        passwordRepeatValue.text
    )
}