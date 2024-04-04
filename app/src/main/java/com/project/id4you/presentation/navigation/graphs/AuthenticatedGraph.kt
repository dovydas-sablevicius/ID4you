package com.project.id4you.presentation.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.screens.documentsList.DocumentsListViewModel
import com.project.id4you.presentation.screens.documentsList.UserDocumentPageScreen

fun NavGraphBuilder.authenticatedGraph() {
    navigation(
        route = Routes.Authenticated.Route.route,
        startDestination = Routes.Authenticated.DocumentsPage.route
    ) {
        // Dashboard
        composable(route = Routes.Authenticated.DocumentsPage.route) {
            val viewModel = hiltViewModel<DocumentsListViewModel>()
            UserDocumentPageScreen(state = viewModel.state.value)
        }
    }
}
