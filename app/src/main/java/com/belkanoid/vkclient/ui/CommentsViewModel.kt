package com.belkanoid.vkclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.belkanoid.vkclient.domain.comment.CommentEntity
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.ui.screens.home.comment.CommentsScreenState

class CommentsViewModel: ViewModel() {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState


    fun loadComments(feedPost: FeedEntity) {
        val comments = mutableListOf<CommentEntity>().apply {
            repeat(20) {
                add(CommentEntity(id = it))
            }
        }
        _screenState.value = CommentsScreenState.Comment(
            post = feedPost,
            comments = comments
        )
    }

}