package com.project.id4you.presentation.screens.userLogin

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.id4you.common.TestTags
import com.project.id4you.di.AppModule
import com.project.id4you.presentation.MainActivity
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.screens.userRegistration.RegistrationScreen
import com.project.id4you.presentation.screens.userRegistration.UserRegistrationViewModel
import com.project.id4you.presentation.ui.theme.ID4YouTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class UserLoginScreenKtTest {
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
                    startDestination = Routes.Unauthenticated.Login.route
                ) {
                    composable(route = Routes.Unauthenticated.Login.route)
                    {
                        val viewModel = hiltViewModel<UserLoginViewModel>()
                        UserLoginScreen(
                            state = viewModel.state.value,
                            onEvent = viewModel::onEvent,
                            onSuccessfulLogin = {
                                navController.navigate(route = Routes.Authenticated.Route.route)
                                {
                                    popUpTo(route = Routes.Unauthenticated.Route.route)
                                    {
                                        inclusive = true
                                    }
                                }
                            },
                            onNavigateToRegistration = {
                                navController.navigate(route = Routes.Unauthenticated.Registration.route)
                                {
                                    popUpTo(route = Routes.Unauthenticated.Route.route)
                                    {
                                        inclusive = true
                                    }
                                }
                            })
                    }
                    composable(route = Routes.Unauthenticated.Registration.route) {
                        val viewModel = hiltViewModel<UserRegistrationViewModel>()
                        RegistrationScreen(state = viewModel.state.value,
                            onEvent = viewModel::onEvent,
                            onNavigateToLogin = {
                                navController.navigate(route = Routes.Unauthenticated.Login.route)
                            })
                    }
                }
            }
        }
    }

    @Test
    fun testNavigationToRegistration() {
        composeRule.onNodeWithTag(TestTags.RegistrationScreenColumn).assertDoesNotExist()
        composeRule.onNodeWithTag(TestTags.NavigateToRegistrationButtonTag).assertIsDisplayed()
        composeRule.onNodeWithTag(TestTags.NavigateToRegistrationButtonTag).performClick()
        composeRule.onNodeWithTag(TestTags.RegistrationScreenColumn).assertIsDisplayed()
    }
}