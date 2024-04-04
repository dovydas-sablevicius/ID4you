package com.project.id4you.presentation.screens.userLogin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.text.TextClickableComponent
import com.project.id4you.presentation.components.text.TextType
import com.project.id4you.presentation.screens.userLogin.components.ScreenHeader
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun UserLoginScreen(
    state: UserLoginState,
    onEvent: (UserLoginEvent) -> Unit,
    onSuccessfulLogin: () -> Unit,
    onNavigateToRegistration: () -> Unit
) {
    val errorMessage = "Login is incorrect."
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        ScreenHeader(onNavigateToRegistration)
        CustomTextField(
            labelText = "Email",
            value = state.email,
            onValueChange = { onEvent(UserLoginEvent.EnteredEmail(it)) }
        )
        CustomTextField(
            labelText = "Password",
            value = state.password,
            onValueChange = { onEvent(UserLoginEvent.EnteredPassword(it)) },
            isPasswordField = true
        )
        ButtonComponent(
            method = {
                onEvent(UserLoginEvent.PressedLoginButton)
            },
            modifier = Modifier.width(375.dp),
            labelText = "Login",
            textColor = AppColor.White,
            buttonColor = AppColor.Blue
        )
        TextClickableComponent(
            labelText = "Forgot your password?",
            textType = TextType.CLICKABLE
        )
    }

    if (state.error.isNotBlank()) {
        ErrorText(errorMessage = errorMessage)
    }

    if (state.isLoading) {
        LoadingIndicator()
    }

    if (state.isSuccess) {
        LaunchedEffect(Unit) {
            onSuccessfulLogin()
        }
    }
}
