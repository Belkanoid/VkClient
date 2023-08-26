package com.belkanoid.vkclient.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.belkanoid.vkclient.ui.MainViewModel
import com.belkanoid.vkclient.ui.screens.feed.FeedScreen
import com.belkanoid.vkclient.ui.navigation.MainNavGraph
import com.belkanoid.vkclient.ui.navigation.rememberNavigationState

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val navigationState = rememberNavigationState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        bottomBar = {
            BottomAppBar {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val items = listOf(
                    com.belkanoid.vkclient.ui.navigation.BottomNavigationItem.Home,
                    com.belkanoid.vkclient.ui.navigation.BottomNavigationItem.Favourite,
                    com.belkanoid.vkclient.ui.navigation.BottomNavigationItem.Profile,
                )

                items.forEach { item ->
                    BottomNavigationItem(
                        label = {
                            Text(text = item.name)
                        },
                        selected = currentRoute == item.screen.route,
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
    ) {
        val data = viewModel.feedPost.observeAsState()
        MainNavGraph(
            navController = navigationState.navHostController,
            homeScreen = { FeedScreen(feedData = data.value!!, paddingValues = it) },
            favouriteScreen = { CountText(text = "favouriteScreen") },
            profileScreen = { CountText(text = "profileScreen") }
        )
    }
}

@Composable
fun CountText(
    text: String
) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }

    Text(
        modifier = Modifier.clickable { count++ },
        text = "$text $count"
    )
}