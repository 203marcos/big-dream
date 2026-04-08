package com.bigdream.data.repository

import com.bigdream.data.remote.api.PostApi
import com.bigdream.data.remote.dto.CreatePostRequest
import com.bigdream.domain.model.Post
import com.bigdream.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postApi: PostApi,
) : PostRepository {

    override suspend fun getFeed(): Result<List<Post>> {
        return try {
            val posts = postApi.getFeed().map { dto ->
                Post(
                    id = dto.id,
                    authorName = dto.authorName,
                    content = dto.content,
                    likesCount = dto.likesCount,
                    commentsCount = dto.commentsCount,
                    isLikedByUser = dto.isLikedByUser,
                )
            }
            Result.success(posts)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun createPost(content: String): Result<Post> {
        return try {
            val dto = postApi.createPost(CreatePostRequest(content))
            Result.success(
                Post(
                    id = dto.id,
                    authorName = dto.authorName,
                    content = dto.content,
                    likesCount = dto.likesCount,
                    commentsCount = dto.commentsCount,
                    isLikedByUser = dto.isLikedByUser,
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun likePost(postId: Long): Result<Unit> {
        return try {
            postApi.likePost(postId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
