package com.project.id4you.presentation.screens.userRegistration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.screens.userRegistration.components.ScreenHeader
import com.project.id4you.presentation.ui.theme.AppColor

@Composable
fun RegistrationScreen(
    state: UserRegistrationState,
    onEvent: (UserRegistrationEvent) -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val errorMessage = "Oops.. An unexpected error occurred."

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .testTag(TestTags.REGISTRATION_SCREEN)
    ) {
        ScreenHeader(
            headerText = "Sign Up",
            buttonText = "Login",
            onNavigateToLogin = onNavigateToLogin,
            modifier = Modifier.testTag(TestTags.NAVIGATE_TO_LOGIN_BUTTON)
        )
        CustomTextField(
            labelText = "Email",
            value = state.email,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredEmail(it)) },
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_EMAIL_INPUT)
        )
        CustomTextField(
            labelText = "Password",
            value = state.password,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredPassword(it)) },
            isPasswordField = true,
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_PASSWORD_INPUT)
        )
        CustomTextField(
            labelText = "Repeat Password",
            value = state.passwordAgain,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredPasswordAgain(it)) },
            isPasswordField = true,
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_PASSWORD_CONFIRM_INPUT)
        )
        ButtonComponent(
            modifier = Modifier
                .width(375.dp)
                .testTag(TestTags.SIGN_UP_BUTTON),
            labelText = "Sign Up",
            method = { onEvent(UserRegistrationEvent.PressedRegisterButton) },
            textColor = AppColor.White,
            buttonColor = AppColor.Blue
        )
    }
    if (state.error.isNotBlank()) {
        ErrorText(errorMessage = errorMessage)
    }

    if (state.isLoading) {
        LoadingIndicator(modifier = Modifier.testTag(TestTags.LOADING_COMPONENT))
    }

    if (state.isSuccess) {
        LaunchedEffect(Unit) {
            onNavigateToLogin()
        }
    }
}

