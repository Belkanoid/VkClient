package com.belkanoid.vkclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.belkanoid.vkclient.domain.feed.FeedEntity
import com.belkanoid.vkclient.domain.feed.PostStatistics

class MainViewModel: ViewModel() {

    private val _feedPost = MutableLiveData(FeedEntity())
    val feedPost: LiveData<FeedEntity> = _feedPost

    fun updateStatistics(newItem: PostStatistics) {
        val oldStatistics = _feedPost.value!!.postStatistics
        val newStatistics = oldStatistics.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == newItem.type) {
                    oldItem.copy(value = oldItem.value + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPost.value = _feedPost.value?.copy(postStatistics = newStatistics)
    }



}