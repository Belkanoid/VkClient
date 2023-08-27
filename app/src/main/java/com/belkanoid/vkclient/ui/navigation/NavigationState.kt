package com.belkanoid.vkclient.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.AnimBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController
) {

    fun navigateTo(route: String) {
        navHostController.navigate(route){
            launchSingleTop = true
            restoreState = true
            popUpTo(navHostController.graph.startDestinationId){
                saveState = true
            }
        }
    }

    fun navigateBack(){
        navHostController.navigate(navHostController.graph.last().id)
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