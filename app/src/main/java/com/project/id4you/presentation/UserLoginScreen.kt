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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.TextClickableComponent
import com.project.id4you.presentation.components.TextComponent
import com.project.id4you.presentation.ui.theme.AppColor
import com.project.id4you.presentation.userLogin.UserLoginViewModel

@Composable
fun UserLoginScreen(
    navController: NavController,
    viewModel: UserLoginViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val errorMessage = "Login is incorrect."

    val inputStateEmail = remember { mutableStateOf(TextFieldValue()) }
    val (inputValueEmail, setInputValueEmail) = inputStateEmail

    val inputStatePassword = remember { mutableStateOf(TextFieldValue()) }
    val (inputValuePassword, setInputValuePassword) = inputStatePassword

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        ScreenHeader(navController)
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
            method = {
                login(
                    viewModel = viewModel,
                    emailValue = inputValueEmail,
                    passwordValue = inputValuePassword
                )
            },
            modifier = Modifier.width(375.dp),
            labelText = "Login",
            textColor = AppColor.White,
            buttonColor = AppColor.Blue
        )
        TextClickableComponent(
            labelText = "Forgot your password?",
            fontWeight = 500,
            fontSize = 12.sp
        )
    }

    if (state.error.isNotBlank()) {
        ErrorText(errorMessage = errorMessage)
    }

    if (state.isLoading) {
        LoadingIndicator()
    }

    if (state.isSuccess) {
        navController.navigate("document-page-screen")
        viewModel.resetState()
    }
}

@Composable
fun ScreenHeader(navController: NavController) {
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
            method = { navController.navigate("registration-screen") },
            labelText = "Sign Up",
            fontWeight = 500,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

fun login(
    viewModel: UserLoginViewModel,
    emailValue: TextFieldValue,
    passwordValue: TextFieldValue,
) {
    viewModel.loginUser(
        emailValue.text,
        passwordValue.text,
    )
}
