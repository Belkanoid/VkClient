package com.belkanoid.vkclient.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MainNavGraph(
    navController: NavHostController,
    homeScreen: @Composable () -> Unit,
    favouriteScreen: @Composable () -> Unit,
    profileScreen: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route){
            homeScreen()
        }
        composable(Screen.Favourite.route){
            favouriteScreen()
        }
        composable(Screen.Profile.route){
            profileScreen()
        }
    }
}