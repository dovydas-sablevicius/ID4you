package com.project.id4you.presentation.screens.userRegistration.components

import androidx.compose.runtime.Composable
import com.project.id4you.presentation.components.LoadingIndicator
import com.project.id4you.presentation.screens.userRegistration.UserRegistrationState

@Composable
fun LoadingState(state: UserRegistrationState) {
    if (state.isLoading) {
        LoadingIndicator()
    }
}
