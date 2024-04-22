package com.project.id4you.presentation.navigation.graphs

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.project.id4you.presentation.navigation.Routes
import com.project.id4you.presentation.screens.createDocument.CreateDocumentScreen
import com.project.id4you.presentation.screens.createDocument.CreateDocumentViewModel
import com.project.id4you.presentation.screens.documentDetail.DocumentDetailScreen
import com.project.id4you.presentation.screens.documentDetail.DocumentDetailViewModel
import com.project.id4you.presentation.screens.documentQr.DocumentQrScreen
import com.project.id4you.presentation.screens.documentQr.DocumentQrViewModel
import com.project.id4you.presentation.screens.documentUpload.DocumentUploadFrontScreen
import com.project.id4you.presentation.screens.documentUpload.DocumentUploadFrontViewModel
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
        documentCreateScreen(navController)
        documentUploadFrontScreen(navController)
        documentUploadFrontPreviewScreen(navController)
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
            },
            onNavigateToDocumentCreationScreen = {
                navController.navigate(route = Routes.Authenticated.DocumentCreation.route)
            }
        )
    }
}

private fun NavGraphBuilder.documentDetailScreen(navController: NavController) {
    composable(route = Routes.Authenticated.DocumentDetail.route + "/{documentId}") {
        val viewModel = hiltViewModel<DocumentDetailViewModel>()
        DocumentDetailScreen(
            state = viewModel.state.value,
            onNavigateToDocumentQrScreen = { documentId ->
                navController.navigate(
                    route = Routes.Authenticated.DocumentQr.route + "/${documentId}"
                )
            }
        )
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

private fun NavGraphBuilder.documentCreateScreen(navController: NavController) {
    composable(route = Routes.Authenticated.DocumentCreation.route) {
        val viewModel = hiltViewModel<CreateDocumentViewModel>()
        CreateDocumentScreen(
            state = viewModel.state.value,
            onEvent = viewModel::onEvent,
            onNavigateToUploadDocumentFront = { documentName, documentType ->
                navController.navigate(route = Routes.Authenticated.DocumentUploadFront.route + "?documentName=${documentName}&documentType=${documentType}")
            }
        )
    }
}

private fun NavGraphBuilder.documentUploadFrontScreen(navController: NavController) {
    composable(route = Routes.Authenticated.DocumentUploadFront.route + "?documentName={documentName}&documentType={documentType}") { backStackEntry ->
        val viewModel = hiltViewModel<DocumentUploadFrontViewModel>()
        val documentName = backStackEntry.arguments?.getString("documentName")
        val documentType = backStackEntry.arguments?.getString("documentType")

        DocumentUploadFrontScreen(
            documentName = documentName ?: "",
            documentType = documentType ?: "",

            /*state = viewModel.state.value,
            onNavigateToUploadDocumentFrontPreview = {
                navController.navigate(route = Routes.Authenticated.DocumentUploadFrontPreview.route)
            }*/
        )
    }
}

private fun NavGraphBuilder.documentUploadFrontPreviewScreen(navController: NavController) {
    /*composable(route = Routes.Authenticated.DocumentUploadFront.route) {
        //val viewModel = hiltViewModel<DocumentFrontUploadViewModel>()
        /*DocumentUploadScreen(

        )*/
    }*/
}



