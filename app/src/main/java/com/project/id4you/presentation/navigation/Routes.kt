package com.project.id4you.presentation.navigation

sealed class Routes {
    sealed class Unauthenticated(val route: String) : Routes() {
        data object Route : Unauthenticated(route = "unauthenticated")
        data object Login : Unauthenticated(route = "login-screen")
        data object Registration : Unauthenticated(route = "registration-screen")
    }

    sealed class Authenticated(val route: String) : Routes() {
        data object Route : Authenticated(route = "authenticated")
        data object DocumentsPage : Authenticated(route = "document-page-screen")
        data object DocumentDetail : Authenticated(route = "document-detail-screen")
        data object DocumentQr : Authenticated(route = "document-qr-screen")
    }
}
