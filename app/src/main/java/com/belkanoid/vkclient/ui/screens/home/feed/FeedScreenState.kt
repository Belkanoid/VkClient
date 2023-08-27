package com.belkanoid.vkclient.ui.screens.home.feed

import com.belkanoid.vkclient.domain.feed.FeedEntity


sealed class FeedScreenState{

    object Initial: FeedScreenState()

    data class Posts(val posts: List<FeedEntity>): FeedScreenState()

}