package com.belkanoid.vkclient.domain.feed

import java.lang.IllegalStateException

data class FeedStatistics(
    val type: StatisticsType,
    val value: Long,
)

enum class StatisticsType{
    LIKE, COMMENT, SHARE, VIEW
}

fun List<FeedStatistics>.getItemByType(type: StatisticsType): FeedStatistics {
    return this.find { it.type == type} ?: throw IllegalStateException("not found $type type")
}
