package com.bigdream.domain.model

data class Post(
    val id: Long,
    val authorName: String,
    val content: String,
    val likesCount: Int = 0,
    val commentsCount: Int = 0,
    val isLikedByUser: Boolean = false,
)
