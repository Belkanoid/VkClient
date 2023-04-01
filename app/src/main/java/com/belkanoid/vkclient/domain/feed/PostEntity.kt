package com.belkanoid.vkclient.domain.feed

import com.belkanoid.vkclient.R

data class PostEntity(
    val id: Int = 0,
    val postCommunityName: String = "innocence",
    val postDate: Long = 234325235,
    val postText: String = "ты всего лишь облик под видом человека",
    val postImageResId: Int = R.drawable.ic_post_image,
    val postStatistics: PostStatistics = PostStatistics(
        likes = 403,
        comments = 44,
        shares = 63,
        views = 382000
    )
)


