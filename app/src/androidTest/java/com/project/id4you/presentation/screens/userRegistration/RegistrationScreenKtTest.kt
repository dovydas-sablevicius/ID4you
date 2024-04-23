package com.project.id4you.presentation.screens.userRegistration

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.project.id4you.common.TestTags
import com.project.id4you.di.AppModule
import com.project.id4you.presentation.MainActivity
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.navigation.graphs.authenticatedGraph
import com.project.id4you.presentation.navigation.graphs.unauthenticatedGraph
import com.project.id4you.presentation.ui.theme.ID4YouTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import junit.framework.TestCase.fail
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class RegistrationScreenKtTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.activity.setContent {
            ID4YouTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Routes.Unauthenticated.Route.route
                ) {
                    unauthenticatedGraph(navController)
                    authenticatedGraph(navController)
                }
            }
        }
    }

    @Test
    fun allImportantComponentsPresent() {

        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN).assertDoesNotExist()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).performClick()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_LOGIN_BUTTON).assertIsDisplayed()

        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_EMAIL_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_NAME_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_SURNAME_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_BIRTH_DATE_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PERSONAL_CODE_INPUT)
            .assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_CONFIRM_INPUT)
            .assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.SIGN_UP_BUTTON).assertIsDisplayed()
    }

    @Test
    fun testNavigationToLogin() {
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).performClick()

        composeRule.onNodeWithTag(TestTags.LOGIN_SCREEN).assertDoesNotExist()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_LOGIN_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_LOGIN_BUTTON).performClick()
        composeRule.onNodeWithTag(TestTags.LOGIN_SCREEN).assertIsDisplayed()
    }

    @Test
    fun testRegistration() {
        val email: String = "test@test.com"
        val password: String = "1234567890"
        val passwordAgain: String = "1234567890"
        val name: String = "John"
        val surname: String = "Doe"
        val birthDate: String = "2000-01-01"
        val personalCode: String = "12345678901"

        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).performClick()

        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_EMAIL_INPUT).performTextInput(email)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_INPUT)
            .performTextInput(password)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_CONFIRM_INPUT)
            .performTextInput(passwordAgain)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_NAME_INPUT).performTextInput(name)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_SURNAME_INPUT)
            .performTextInput(surname)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_BIRTH_DATE_INPUT)
            .performTextInput(birthDate)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PERSONAL_CODE_INPUT)
            .performTextInput(personalCode)
        composeRule.onNodeWithTag(TestTags.SIGN_UP_BUTTON).performClick()

        runBlocking { delay(200L) }
        composeRule.onNodeWithTag(TestTags.LOADING_COMPONENT).assertIsDisplayed()
        runBlocking { delay(700L) }
        composeRule.onNodeWithTag(TestTags.LOGIN_SCREEN).assertIsDisplayed()
    }

    @Test
    fun testErrorMessage() {

        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).performClick()

        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_EMAIL_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_INPUT).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_CONFIRM_INPUT)
            .assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.SIGN_UP_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.SIGN_UP_BUTTON).performClick()
        runBlocking { delay(1000L) }
        composeRule.onNodeWithTag(TestTags.ERROR_MESSAGE).assertIsDisplayed()
            .assertTextContains("Oops.. An unexpected error occurred.")
    }

    @Test
    fun testRegistrationTime() {
        val email: String = "test@test.com"
        val password: String = "1234567890"
        val passwordAgain: String = "1234567890"
        val name: String = "John"
        val surname: String = "Doe"
        val birthDate: String = "2000-01-01"
        val personalCode: String = "12345678901"

        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NAVIGATE_TO_REGISTRATION_BUTTON).performClick()

        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_EMAIL_INPUT).performTextInput(email)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_INPUT)
            .performTextInput(password)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PASSWORD_CONFIRM_INPUT)
            .performTextInput(passwordAgain)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_NAME_INPUT).performTextInput(name)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_SURNAME_INPUT)
            .performTextInput(surname)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_BIRTH_DATE_INPUT)
            .performTextInput(birthDate)
        composeRule.onNodeWithTag(TestTags.REGISTRATION_SCREEN_PERSONAL_CODE_INPUT)
            .performTextInput(personalCode)
        composeRule.onNodeWithTag(TestTags.SIGN_UP_BUTTON).performClick()

        val endTimeMillis = System.currentTimeMillis() + 30000
        while (System.currentTimeMillis() < endTimeMillis) {
            try {
                composeRule.onNodeWithTag(TestTags.LOGIN_SCREEN).assertIsDisplayed()
                return
            } catch (e: Throwable) {
            }
        }
        fail("Login screen did not appear within 30 seconds")
    }


}