package com.project.id4you.presentation.screens.userRegistration

sealed class UserRegistrationEvent {
    data class EnteredEmail(val value: String) : UserRegistrationEvent()
    data class EnteredPassword(val value: String) : UserRegistrationEvent()
    data class EnteredPasswordAgain(val value: String) : UserRegistrationEvent()
    data class EnteredName(val value: String) : UserRegistrationEvent()
    data class EnteredSurname(val value: String) : UserRegistrationEvent()
    data class EnteredBirthDate(val value: String) : UserRegistrationEvent()
    data class EnteredPersonalCode(val value: String) : UserRegistrationEvent()
    data object PressedRegisterButton : UserRegistrationEvent()
}
