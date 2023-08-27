package com.belkanoid.vkclient.ui.screens.home.comment

import com.belkanoid.vkclient.domain.comment.CommentEntity
import com.belkanoid.vkclient.domain.feed.FeedEntity

sealed class CommentsScreenState{
    object Initial: CommentsScreenState()

    data class Comment(val post: FeedEntity, val comments: List<CommentEntity>): CommentsScreenState()

}
