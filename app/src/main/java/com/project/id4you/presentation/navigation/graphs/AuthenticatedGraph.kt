package com.project.id4you.presentation.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.screens.documentDetail.DocumentDetailScreen
import com.project.id4you.presentation.screens.documentDetail.DocumentDetailViewModel
import com.project.id4you.presentation.screens.documentQr.DocumentQrScreen
import com.project.id4you.presentation.screens.documentQr.DocumentQrViewModel
import com.project.id4you.presentation.screens.documentsList.DocumentsListScreen
import com.project.id4you.presentation.screens.documentsList.DocumentsListViewModel

fun NavGraphBuilder.authenticatedGraph(navController: NavController) {
    navigation(
        route = Routes.Authenticated.Route.route,
        startDestination = Routes.Authenticated.DocumentsPage.route
    ) {
        documentsListScreen(navController)
        documentDetailScreen(navController)
        documentQrScreen()
    }
}

private fun NavGraphBuilder.documentsListScreen(navController: NavController) {
    composable(route = Routes.Authenticated.DocumentsPage.route) {
        val viewModel = hiltViewModel<DocumentsListViewModel>()
        DocumentsListScreen(
            state = viewModel.state.value,
            onNavigateToDocumentDetailScreen = { documentId ->
                navController.navigate(
                    route = Routes.Authenticated.DocumentDetail.route + "/${documentId}"
                )
            }
        )
    }
}

private fun NavGraphBuilder.documentDetailScreen(navController: NavController) {
    composable(route = Routes.Authenticated.DocumentDetail.route + "/{documentId}") {
        val viewModel = hiltViewModel<DocumentDetailViewModel>()
        DocumentDetailScreen(
            state = viewModel.state.value
        ) { documentId ->
            navController.navigate(
                route = Routes.Authenticated.DocumentQr.route + "/${documentId}"
            )
        }
    }
}

private fun NavGraphBuilder.documentQrScreen() {
    composable(route = Routes.Authenticated.DocumentQr.route + "/{documentId}") {
        val viewModel = hiltViewModel<DocumentQrViewModel>()
        DocumentQrScreen(
            state = viewModel.state.value,
            onEvent = viewModel::onEvent,
        )
    }
}
