package com.bigdream.domain.repository

import com.bigdream.domain.model.Post

interface PostRepository {
    suspend fun getFeed(): Result<List<Post>>
    suspend fun createPost(content: String): Result<Post>
    suspend fun likePost(postId: Long): Result<Unit>
}
