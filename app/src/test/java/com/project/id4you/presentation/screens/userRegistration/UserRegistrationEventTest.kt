package com.project.id4you.presentation.screens.userRegistration

import org.junit.Test

class UserRegistrationEventTest {
    @Test
    fun testEnteredEmailEvent() {
        val email = "test@test.com"
        val enteredEmailEvent = UserRegistrationEvent.EnteredEmail(email)

        val eventEmailValue = enteredEmailEvent.value

        assert(email == eventEmailValue)
    }

    @Test
    fun testEnteredPasswordEvent() {
        val password = "01234567890"
        val enteredPasswordEvent = UserRegistrationEvent.EnteredPassword(password)

        val eventPasswordValue = enteredPasswordEvent.value

        assert(password == eventPasswordValue)
    }

    @Test
    fun testEnteredPasswordAgainEvent() {
        val passwordAgain = "01234567890"
        val enteredPasswordAgainEvent =
            UserRegistrationEvent.EnteredPasswordAgain(passwordAgain)

        val eventPasswordAgainValue = enteredPasswordAgainEvent.value

        assert(passwordAgain == eventPasswordAgainValue)
    }

    @Test
    fun testPressedRegisterButtonEvent() {
        UserRegistrationEvent.PressedRegisterButton
    }
}
