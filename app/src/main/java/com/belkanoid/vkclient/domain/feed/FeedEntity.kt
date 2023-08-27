package com.belkanoid.vkclient.domain.feed

import com.belkanoid.vkclient.R

data class FeedEntity(
    val id: Int = 0,
    val postCommunityName: String = "innocence",
    val postDate: Long = 234325235,
    val postText: String = "ты всего лишь облик под видом человека",
    val postImageResId: Int = R.drawable.ic_post_image,
    val feedStatistics: List<FeedStatistics> = listOf(
        FeedStatistics(type = StatisticsType.LIKE, value = 403),
        FeedStatistics(type = StatisticsType.COMMENT, value = 44),
        FeedStatistics(type = StatisticsType.SHARE, value = 63),
        FeedStatistics(type = StatisticsType.VIEW, value = 38200),
    )
)


