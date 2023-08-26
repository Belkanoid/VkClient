package com.belkanoid.vkclient.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavigationItem(
    val screen: Screen,
    val name: String,
    val iconImageVector: ImageVector
) {
    object Home: BottomNavigationItem(
        Screen.Home,
        "Main",
        Icons.Outlined.Home
    )
    object Favourite: BottomNavigationItem(
        Screen.Favourite,
        "Favourite",
        Icons.Outlined.Favorite
    )
    object Profile: BottomNavigationItem(
        Screen.Profile,
        "Profile",
        Icons.Outlined.Person
    )
}
