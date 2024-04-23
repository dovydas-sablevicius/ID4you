package com.project.id4you.presentation.screens.documentQr

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.project.id4you.common.TestTags
import com.project.id4you.di.AppModule
import com.project.id4you.presentation.MainActivity
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.navigation.graphs.authenticatedGraph
import com.project.id4you.presentation.navigation.graphs.unauthenticatedGraph
import com.project.id4you.presentation.screens.documentQr.Constants.JWT_EXPIRATION_TIME
import com.project.id4you.presentation.ui.theme.ID4YouTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class DocumentQrScreenKtTest {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private val documentId = "511151"

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
                navController.navigate(Routes.Authenticated.DocumentQr.route + "/${documentId}")
            }
        }
    }

    @Test
    fun documentQrScreenComponentsAreDisplayed_whenDocumentIdIsNotEmpty() {
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_SCREEN).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_HEADER).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_SCAN_INSTRUCTIONS).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_TIME_REMAINING).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_REGENERATE_BUTTON).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_CODE_IMAGE).assertIsDisplayed()
    }

    @Test
    fun timerIsDecrementingToZero_whenNavigatedToDocumentQrScreen() {
        for (i in 29 downTo 1) {
            composeRule.onNodeWithText("Time remaining: $i seconds").assertIsDisplayed()
            Thread.sleep(1000)
        }
    }

    @Test
    fun qrCodeAndTimerAreRegenerated_whenTimerReachesZero() {
        Thread.sleep(JWT_EXPIRATION_TIME.toLong())
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_CODE_IMAGE).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_TIME_REMAINING).assertIsDisplayed()
    }

    @Test
    fun qrCodeIsRegenerated_whenRegenerateButtonIsClicked() {
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_REGENERATE_BUTTON).performClick()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_CODE_IMAGE).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_TIME_REMAINING).assertIsDisplayed()
    }

    @Test
    fun errorIsNotDisplayed_whenDocumentIdIsNotEmpty() {
        composeRule.onNodeWithTag(TestTags.DOCUMENT_QR_ERROR).assertDoesNotExist()
    }
}
