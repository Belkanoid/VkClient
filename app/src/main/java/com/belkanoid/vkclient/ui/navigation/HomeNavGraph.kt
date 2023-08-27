package com.belkanoid.vkclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeNavGraph(
    feedScreenContent: @Composable () -> Unit,
    commentScreenContent: @Composable () -> Unit,
) {

    navigation(
        startDestination = Screen.Feed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.Feed.route) {
            feedScreenContent()
        }
        composable(Screen.Comment.route) {
            commentScreenContent()
        }
    }

}