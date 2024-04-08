package com.project.id4you.presentation.screens.userLogin

import org.junit.Test

class UserLoginEventTest {
    @Test
    fun testEnteredEmailEvent() {
        val email = "test@test.com"
        val enteredEmailEvent = UserLoginEvent.EnteredEmail(email)

        val eventEmailValue = enteredEmailEvent.value

        assert(email == eventEmailValue)
    }

    @Test
    fun testEnteredPasswordEvent() {
        val password = "01234567890"
        val enteredPasswordEvent = UserLoginEvent.EnteredPassword(password)

        val eventPasswordValue = enteredPasswordEvent.value

        assert(password == eventPasswordValue)
    }

    @Test
    fun testPressedLoginButtonEvent() {
        UserLoginEvent.PressedLoginButton
    }
}
