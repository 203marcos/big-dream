package com.bigdream.data.remote.api

import com.bigdream.data.remote.dto.AuthResponse
import com.bigdream.data.remote.dto.LoginRequest
import com.bigdream.data.remote.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse
}
