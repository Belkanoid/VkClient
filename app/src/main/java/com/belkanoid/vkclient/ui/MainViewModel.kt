package com.belkanoid.vkclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.domain.feed.FeedStatistics
import com.belkanoid.vkclient.ui.screens.home.feed.FeedScreenState

class MainViewModel: ViewModel() {

    private val sourceList = mutableListOf<FeedEntity>().apply {
        repeat(10) {
            add(FeedEntity(id = it))
        }
    }
    private val initialState = FeedScreenState.Posts(posts = sourceList)

    private val _screenState = MutableLiveData<FeedScreenState>(initialState)
    val screenState: LiveData<FeedScreenState> = _screenState


    fun updateCount(feedPost: FeedEntity, item: FeedStatistics) {
        val currentState = screenState.value
        if (currentState !is FeedScreenState.Posts) return

        val oldPosts = currentState.posts.toMutableList()
        val oldStatistics = feedPost.feedStatistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    oldItem.copy(value = oldItem.value + 1)
                } else {
                    oldItem
                }
            }
        }
        val newFeedPost = feedPost.copy(feedStatistics = newStatistics)
        val newPosts = oldPosts.apply {
            replaceAll {
                if (it.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    it
                }
            }
        }
        _screenState.value = FeedScreenState.Posts(posts = newPosts)
    }



}