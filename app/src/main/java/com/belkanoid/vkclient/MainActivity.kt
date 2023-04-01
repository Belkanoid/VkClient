package com.belkanoid.vkclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.belkanoid.vkclient.domain.feed.*
import com.belkanoid.vkclient.screens.feed.FeedPost
import com.belkanoid.vkclient.ui.theme.VkClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkClientTheme {
                val postData = remember { mutableStateOf(PostEntity())}
                FeedPost(
                    postData = postData.value,
                    onLikeClick = {
                        postData.value = postData.value.copy(
                            postStatistics = postData.value.postStatistics.addLike()
                        )
                    },
                    onCommentClick = {
                        postData.value = postData.value.copy(
                            postStatistics = postData.value.postStatistics.addComment()
                        )

                    },
                    onShareClick = {
                        postData.value = postData.value.copy(
                            postStatistics = postData.value.postStatistics.addShare()
                        )
                    }
                )
            }
        }
    }
}