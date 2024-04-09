package com.project.id4you.presentation.navigation

import org.junit.Test

val unauthenticatedKClass = Routes.Unauthenticated::class
val authenticatedKClass = Routes.Authenticated::class

class RoutesTest {
    @Test
    fun unauthenticatedRouteReturned() {
        val route: String = "unauthenticated"
        val unauthenticatedRoute = Routes.Unauthenticated.Route
        assert(route == unauthenticatedRoute.route)
        assert(unauthenticatedKClass.isInstance(unauthenticatedRoute))
    }

    @Test
    fun unauthenticatedLoginRouteReturned() {
        val route: String = "login-screen"
        val loginRoute = Routes.Unauthenticated.Login
        assert(route == loginRoute.route)
        assert(unauthenticatedKClass.isInstance(loginRoute))
    }

    @Test
    fun unauthenticatedRegisterRouteReturned() {
        val route: String = "registration-screen"
        val registrationRoute = Routes.Unauthenticated.Registration
        assert(route == registrationRoute.route)
        assert(unauthenticatedKClass.isInstance(registrationRoute))
    }

    @Test
    fun authenticatedRouteReturned() {
        val route: String = "authenticated"
        val authenticatedRoute = Routes.Authenticated.Route
        assert(route == authenticatedRoute.route)
        assert(authenticatedKClass.isInstance(authenticatedRoute))
    }

    @Test
    fun authenticatedDocumentsPageRouteReturned() {
        val route: String = "document-page-screen"
        val documentsPageRoute = Routes.Authenticated.DocumentsPage
        assert(route == documentsPageRoute.route)
        assert(authenticatedKClass.isInstance(documentsPageRoute))
    }

    @Test
    fun authenticatedDocumentDetailPageRouteReturned() {
        val route: String = "document-detail-screen"
        val documentDetailsPageRoute = Routes.Authenticated.DocumentDetail
        assert(route == documentDetailsPageRoute.route)
        assert(authenticatedKClass.isInstance(documentDetailsPageRoute))
    }

    @Test
    fun authenticatedDocumentQrPageRouteReturned() {
        val route: String = "document-qr-screen"
        val documentQrPageRoute = Routes.Authenticated.DocumentQr
        assert(route == documentQrPageRoute.route)
        assert(authenticatedKClass.isInstance(documentQrPageRoute))
    }
}