package com.bigdream.domain.repository

import com.bigdream.domain.model.User

interface UserRepository {
    suspend fun getProfile(userId: Long): Result<User>
    suspend fun updateProfile(user: User): Result<User>
    suspend fun getConnections(): Result<List<User>>
    suspend fun addConnection(userId: Long): Result<Unit>
}
