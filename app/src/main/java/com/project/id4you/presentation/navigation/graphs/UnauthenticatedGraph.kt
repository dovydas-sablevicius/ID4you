package com.project.id4you.presentation.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.screens.userLogin.UserLoginScreen
import com.project.id4you.presentation.screens.userLogin.UserLoginViewModel
import com.project.id4you.presentation.screens.userRegistration.RegistrationScreen
import com.project.id4you.presentation.screens.userRegistration.UserRegistrationViewModel

fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = Routes.Unauthenticated.Route.route,
        startDestination = Routes.Unauthenticated.Login.route
    )
    {
        registrationScreen(navController)
        loginScreen(navController)
    }
}

private fun NavGraphBuilder.loginScreen(navController: NavController) {
    composable(Routes.Unauthenticated.Login.route) {
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
            }
        )
    }
}

private fun NavGraphBuilder.registrationScreen(navController: NavController) {
    composable(route = Routes.Unauthenticated.Registration.route) {
        val viewModel = hiltViewModel<UserRegistrationViewModel>()
        RegistrationScreen(state = viewModel.state.value,
            onEvent = viewModel::onEvent,
            onNavigateToLogin = {
                navController.navigate(route = Routes.Unauthenticated.Login.route)
            })
    }
}
