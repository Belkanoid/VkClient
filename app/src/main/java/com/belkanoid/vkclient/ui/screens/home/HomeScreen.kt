package com.belkanoid.vkclient.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.ui.navigation.BottomNavigation
import com.belkanoid.vkclient.ui.navigation.MainNavGraph
import com.belkanoid.vkclient.ui.navigation.rememberNavigationState
import com.belkanoid.vkclient.ui.screens.home.comment.CommentScreen
import com.belkanoid.vkclient.ui.screens.home.feed.FeedScreen

@Composable
fun HomeScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        bottomBar = {
            BottomNavigation(navigationState = navigationState)
        }
    ) {
        val currentPost: MutableState<FeedEntity?> = rememberSaveable {
            mutableStateOf(null)
        }
        MainNavGraph(
            navController = navigationState.navHostController,
            homeScreen = {
                if (currentPost.value != null) {
                    CommentScreen(
                        post = currentPost.value!!,
                        paddingValues = it,
                        onBackPressed = {
                            currentPost.value = null
                        }
                    )
                } else {
                    FeedScreen(
                        paddingValues = it,
                        onCommentClick = {
                            currentPost.value = it
                        }
                    )
                }
            },
            favouriteScreen = { },
            profileScreen = { }
        )
    }
}
