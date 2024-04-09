package com.project.id4you.presentation.screens.documentList

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
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
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class DocumentListScreenKtTest {

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
                navController.navigate(Routes.Authenticated.DocumentsPage.route)
            }
        }
    }

    @Test
    fun allImportantComponentsPresent() {

        composeRule.onNodeWithTag(TestTags.DOCUMENT_LIST_SCREEN).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_LIST_HEADER).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.DOCUMENT_LIST).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.ID_CARD).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.SCAN_BUTTON).assertIsDisplayed()
    }
}

