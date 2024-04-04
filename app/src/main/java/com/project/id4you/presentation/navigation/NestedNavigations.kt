package com.project.id4you.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.id4you.presentation.documentsList.DocumentsListViewModel
import com.project.id4you.presentation.documentsList.UserDocumentPageScreen
import com.project.id4you.presentation.userLogin.UserLoginScreen
import com.project.id4you.presentation.userLogin.UserLoginViewModel
import com.project.id4you.presentation.userRegistration.RegistrationScreen
import com.project.id4you.presentation.userRegistration.UserRegistrationViewModel

fun NavGraphBuilder.unauthenticatedGraph(navController: NavController) {
    navigation(
        route = Routes.Unauthenticated.Route.route,
        startDestination = Routes.Unauthenticated.Login.route
    )
    {
        composable(route = Routes.Unauthenticated.Registration.route) {
            val viewModel = hiltViewModel<UserRegistrationViewModel>()
            RegistrationScreen(state = viewModel.state.value,
                onEvent = viewModel::onEvent,
                onNavigateToLogin = {
                    navController.navigate(route = Routes.Unauthenticated.Login.route)
                })
        }
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
}

fun NavGraphBuilder.authenticatedGraph() {
    navigation(
        route = Routes.Authenticated.Route.route,
        startDestination = Routes.Authenticated.DocumentsPage.route
    ) {
        // Dashboard
        composable(route = Routes.Authenticated.DocumentsPage.route) {
            val viewModel = hiltViewModel<DocumentsListViewModel>();
            UserDocumentPageScreen(state = viewModel.state.value)
        }
    }
}
