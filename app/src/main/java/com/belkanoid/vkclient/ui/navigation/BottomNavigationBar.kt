package com.belkanoid.vkclient.ui.navigation

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navigationState: NavigationState
) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        val items = listOf(
            BottomNavigationItem.Home,
            BottomNavigationItem.Favourite,
            BottomNavigationItem.Profile,
        )

        items.forEach { item ->
            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            BottomNavigationItem(
                label = {
                    Text(text = item.name)
                },
                selectedContentColor = MaterialTheme.colors.onPrimary,
                unselectedContentColor = MaterialTheme.colors.onSecondary,
                selected = selected,
                onClick = { navigationState.navigateTo(item.screen.route) },
                icon = {
                    Icon(
                        imageVector = item.iconImageVector,
                        contentDescription = null
                    )
                }
            )
        }
    }

}