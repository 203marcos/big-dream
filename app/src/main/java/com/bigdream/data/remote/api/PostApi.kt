package com.bigdream.data.remote.api

import com.bigdream.data.remote.dto.CreatePostRequest
import com.bigdream.data.remote.dto.PostResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostApi {
    @GET("posts")
    suspend fun getFeed(): List<PostResponse>

    @POST("posts")
    suspend fun createPost(@Body request: CreatePostRequest): PostResponse

    @POST("posts/{id}/like")
    suspend fun likePost(@Path("id") postId: Long)
}
