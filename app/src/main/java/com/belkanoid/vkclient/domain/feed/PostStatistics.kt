package com.belkanoid.vkclient.domain.feed

data class PostStatistics(
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val views: Int
)

fun PostStatistics.addLike(): PostStatistics {
    return this.copy(likes = likes + 1)
}

fun PostStatistics.addComment(): PostStatistics {
    return this.copy(comments = comments + 1)
}

fun PostStatistics.addShare(): PostStatistics {
    return this.copy(shares = shares + 1)
}

fun PostStatistics.addView(): PostStatistics {
    return this.copy(views = views + 1)
}
