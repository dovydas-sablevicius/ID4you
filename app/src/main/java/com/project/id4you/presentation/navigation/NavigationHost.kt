package com.project.id4you.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.project.id4you.presentation.navigation.graphs.authenticatedGraph
import com.project.id4you.presentation.navigation.graphs.unauthenticatedGraph

fun NavGraphBuilder.createNavigationGraph(navController: NavController) {
    unauthenticatedGraph(navController)
    authenticatedGraph()
}
