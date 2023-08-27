package com.belkanoid.vkclient.domain.comment

data class CommentEntity(
    val id: Int = 0,
    val author: String = "Author $id",
    val text: String = "Lorem ispum dollar",
    val date: String ="23 Aug at 14:43"
)
