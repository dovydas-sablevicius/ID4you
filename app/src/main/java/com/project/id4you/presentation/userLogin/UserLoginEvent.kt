package com.project.id4you.presentation.userLogin

sealed class UserLoginEvent {
    data class EnteredEmail(val value: String) : UserLoginEvent()
    data class EnteredPassword(val value: String) : UserLoginEvent()
    data object PressedLoginButton : UserLoginEvent()
}