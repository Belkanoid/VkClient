package com.belkanoid.vkclient.ui.screens.feed

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.belkanoid.vkclient.domain.feed.FeedEntity

@Composable
fun FeedScreen(feedData: FeedEntity, paddingValues: PaddingValues) {
    FeedPost(postData = feedData, onLikeClick = {}, onCommentClick = {}, onShareClick = {})
}