package com.belkanoid.vkclient.ui.navigation

sealed class Screen(
    val route: String
) {
    object Feed: Screen(FEED_SCREEN)
    object Comment: Screen(COMMENT_SCREEN)
    object Favourite: Screen(FAVOURITE_SCREEN)
    object Profile: Screen(PROFILE_SCREEN)
    object Home: Screen(HOME_SCREEN)

    companion object {
        private const val COMMENT_SCREEN = "comment_screen"
        private const val FEED_SCREEN = "feed_screen"
        private const val HOME_SCREEN = "home"
        private const val FAVOURITE_SCREEN = "favourite_screen"
        private const val PROFILE_SCREEN = "profile_screen"
    }
}