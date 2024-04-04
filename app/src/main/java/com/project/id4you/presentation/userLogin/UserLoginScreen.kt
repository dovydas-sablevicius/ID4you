package com.project.id4you.presentation.userLogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.components.TextClickableComponent
import com.project.id4you.presentation.components.TextComponent
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
        LaunchedEffect(Unit) {
            onSuccessfulLogin()
        }
    }
}

@Composable
fun ScreenHeader(onNavigateToRegistration: () -> Unit) {
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
            method = { onNavigateToRegistration() },
            labelText = "Sign Up",
            fontWeight = 500,
            fontSize = 15.sp
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
}

