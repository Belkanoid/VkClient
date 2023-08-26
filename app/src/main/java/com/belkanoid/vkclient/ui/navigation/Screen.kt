package com.belkanoid.vkclient.ui.navigation

sealed class Screen(
    val route: String
) {
    object Home: Screen(HOME_SCREEN)
    object Favourite: Screen(FAVOURITE_SCREEN)
    object Profile: Screen(PROFILE_SCREEN)

    companion object {
        private const val HOME_SCREEN = "home_screen"
        private const val FAVOURITE_SCREEN = "favourite_screen"
        private const val PROFILE_SCREEN = "profile_screen"
    }
}