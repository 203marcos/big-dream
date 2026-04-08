package com.bigdream.data.repository

import com.bigdream.data.remote.api.UserApi
import com.bigdream.data.remote.dto.UserResponse
import com.bigdream.domain.model.User
import com.bigdream.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi,
) : UserRepository {

    override suspend fun getProfile(userId: Long): Result<User> {
        return try {
            val dto = userApi.getUser(userId)
            Result.success(dto.toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateProfile(user: User): Result<User> {
        return try {
            val dto = userApi.updateUser(
                user.id,
                UserResponse(
                    id = user.id,
                    name = user.name,
                    email = user.email,
                    headline = user.headline,
                    skills = user.skills,
                ),
            )
            Result.success(dto.toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getConnections(): Result<List<User>> {
        return try {
            val users = userApi.getConnections().map { it.toDomain() }
            Result.success(users)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun addConnection(userId: Long): Result<Unit> {
        return try {
            userApi.addConnection(userId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun UserResponse.toDomain() = User(
        id = id,
        name = name,
        email = email,
        headline = headline,
        skills = skills,
    )
}
