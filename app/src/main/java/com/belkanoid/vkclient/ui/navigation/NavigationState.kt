package com.belkanoid.vkclient.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.AnimBuilder
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route){
            launchSingleTop = true
            restoreState = true
            popUpTo(navHostController.graph.findStartDestination().id){
                saveState = true
            }
        }
    }

    fun navigateToCommentScreen(){
        navHostController.navigate(Screen.Comment.route)
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState {
    return remember {
        NavigationState(navHostController = navHostController)
    }
}