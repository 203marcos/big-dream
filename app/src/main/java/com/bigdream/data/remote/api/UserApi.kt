package com.bigdream.data.remote.api

import com.bigdream.data.remote.dto.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Long): UserResponse

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") userId: Long, @Body user: UserResponse): UserResponse

    @GET("connections")
    suspend fun getConnections(): List<UserResponse>

    @POST("connections/{userId}")
    suspend fun addConnection(@Path("userId") userId: Long)
}
