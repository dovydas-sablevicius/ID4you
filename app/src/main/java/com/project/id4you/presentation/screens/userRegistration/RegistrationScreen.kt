package com.project.id4you.presentation.screens.userRegistration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.project.id4you.common.TestTags
import com.project.id4you.presentation.components.ButtonComponent
import com.project.id4you.presentation.components.CustomTextField
import com.project.id4you.presentation.components.ErrorText
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.screens.userRegistration.components.ScreenHeader
import com.project.id4you.presentation.ui.theme.AppColor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("LongMethod")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    state: UserRegistrationState,
    onEvent: (UserRegistrationEvent) -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val errorMessage = "Oops.. An unexpected error occurred."
    val showDatePicker = remember { mutableStateOf(false) }
    val datePickerState = remember { DatePickerState(locale = Locale.getDefault()) }
    val selectedDate = remember { mutableStateOf("") }

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
            labelText = "Name",
            value = state.name,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredName(it)) },
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_NAME_INPUT)
        )
        CustomTextField(
            labelText = "Surname",
            value = state.surname,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredSurname(it)) },
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_SURNAME_INPUT)
        )

        CustomTextField(
            labelText = "Birth Date",
            value = selectedDate.value,
            onValueChange = {
                selectedDate.value = it
                onEvent(UserRegistrationEvent.EnteredBirthDate(it))
            },
            showDatePickerTrigger = true,
            onDatePickerClick = { showDatePicker.value = true },
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_BIRTH_DATE_INPUT)
        )

        if (showDatePicker.value) {
            DatePickerDialog(
                shape = RoundedCornerShape(6.dp),
                colors = DatePickerDefaults.colors(
                    containerColor = AppColor.White,
                ),
                onDismissRequest = {
                    showDatePicker.value = false
                },
                confirmButton = {
                    TextButton(onClick = {
                        showDatePicker.value = false
                        selectedDate.value = datePickerState.selectedDateMillis?.let {
                            val formattedDate =
                                SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS'Z'", Locale.getDefault())
                                    .format(Date(it))
                            onEvent(UserRegistrationEvent.EnteredBirthDate(formattedDate))
                            formattedDate
                        } ?: ""
                    }) {
                        Text(text = "Confirm", color = AppColor.Blue)
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDatePicker.value = false
                    }) {
                        Text(text = "Cancel", color = AppColor.Gray)
                    }
                }
            ) {
                DatePicker(
                    state = datePickerState,
                    colors = DatePickerDefaults.colors(
                        titleContentColor = AppColor.Black,
                        selectedDayContainerColor = AppColor.DisabledBlue,
                        todayContentColor = AppColor.Black,
                        todayDateBorderColor = AppColor.Blue,
                        dayContentColor = AppColor.Blue,
                        yearContentColor = AppColor.Blue,
                        currentYearContentColor = AppColor.Blue,
                        selectedYearContainerColor = AppColor.Blue,
                        containerColor = Color.White
                    )
                )
            }
        }
        CustomTextField(
            labelText = "Personal Code",
            value = state.personalCode,
            onValueChange = { onEvent(UserRegistrationEvent.EnteredPersonalCode(it)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.testTag(TestTags.REGISTRATION_SCREEN_PERSONAL_CODE_INPUT)
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
}
