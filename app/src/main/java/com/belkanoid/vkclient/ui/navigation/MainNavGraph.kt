package com.belkanoid.vkclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation

@Composable
fun MainNavGraph(
    navController: NavHostController,
    feedScreenContent: @Composable () -> Unit,
    commentScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        homeNavGraph(
            feedScreenContent = feedScreenContent,
            commentScreenContent = commentScreenContent
        )
        composable(Screen.Favourite.route){
            favouriteScreenContent()
        }
        composable(Screen.Profile.route){
            profileScreenContent()
        }
    }
}