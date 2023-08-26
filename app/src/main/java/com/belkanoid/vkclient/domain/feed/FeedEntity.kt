package com.belkanoid.vkclient.domain.feed

import com.belkanoid.vkclient.R

data class FeedEntity(
    val id: Int = 0,
    val postCommunityName: String = "innocence",
    val postDate: Long = 234325235,
    val postText: String = "ты всего лишь облик под видом человека",
    val postImageResId: Int = R.drawable.ic_post_image,
    val postStatistics: List<PostStatistics> = listOf(
        PostStatistics(type = StatisticsType.LIKE, value = 403),
        PostStatistics(type = StatisticsType.COMMENT, value = 44),
        PostStatistics(type = StatisticsType.SHARE, value = 63),
        PostStatistics(type = StatisticsType.VIEW, value = 38200),
    )
)


