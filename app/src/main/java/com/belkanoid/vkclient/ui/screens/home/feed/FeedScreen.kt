package com.belkanoid.vkclient.ui.screens.home.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.ui.MainViewModel

@Composable
fun FeedScreen(
    paddingValues: PaddingValues,
    onCommentClick: (FeedEntity) -> Unit,
) {
    val viewModel: MainViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(FeedScreenState.Initial)

    when (val currentState = screenState.value) {
        is FeedScreenState.Initial -> {}
        is FeedScreenState.Posts -> {
            LazyColumn(
                contentPadding = PaddingValues(
                    top = 8.dp,
                    bottom = paddingValues.calculateBottomPadding()
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = currentState.posts,
                    key = { it.id }
                ) { post ->

                    FeedPost(postData = post,
                        onLikeClick = {
                            viewModel.updateCount(post, it)
                        }, onCommentClick = {
                            onCommentClick(post)
                        }, onShareClick = {
                            viewModel.updateCount(post, it)
                        }
                    )

                }
            }
        }
    }
}