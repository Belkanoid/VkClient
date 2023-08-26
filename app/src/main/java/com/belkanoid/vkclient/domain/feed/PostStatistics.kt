package com.belkanoid.vkclient.domain.feed

import java.lang.IllegalStateException

data class PostStatistics(
    val type: StatisticsType,
    val value: Long,
)

enum class StatisticsType{
    LIKE, COMMENT, SHARE, VIEW
}

fun List<PostStatistics>.getItemByType(type: StatisticsType): PostStatistics {
    return this.find { it.type == type} ?: throw IllegalStateException("not found $type type")
}
