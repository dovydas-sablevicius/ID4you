package com.project.id4you.presentation.screens.userRegistration

sealed class UserRegistrationEvent {
    data class EnteredEmail(val value: String) : UserRegistrationEvent()
    data class EnteredPassword(val value: String) : UserRegistrationEvent()
    data class EnteredPasswordAgain(val value: String) : UserRegistrationEvent()
    data object PressedRegisterButton : UserRegistrationEvent()
}
