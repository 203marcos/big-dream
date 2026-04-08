package com.bigdream.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val id: Long,
    val authorName: String,
    val content: String,
    val likesCount: Int,
    val commentsCount: Int,
    val isLikedByUser: Boolean,
)

@Serializable
data class CreatePostRequest(
    val content: String,
)
