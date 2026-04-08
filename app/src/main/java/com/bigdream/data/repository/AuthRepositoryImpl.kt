package com.bigdream.data.repository

import com.bigdream.data.local.SessionManager
import com.bigdream.data.remote.api.AuthApi
import com.bigdream.data.remote.dto.LoginRequest
import com.bigdream.data.remote.dto.RegisterRequest
import com.bigdream.domain.model.AuthToken
import com.bigdream.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val sessionManager: SessionManager,
) : AuthRepository {

    override suspend fun login(email: String, password: String): Result<AuthToken> {
        return try {
            val response = authApi.login(LoginRequest(email, password))
            val token = AuthToken(accessToken = response.token, userId = response.userId)
            sessionManager.saveToken(token)
            Result.success(token)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(name: String, email: String, password: String): Result<AuthToken> {
        return try {
            val response = authApi.register(RegisterRequest(name, email, password))
            val token = AuthToken(accessToken = response.token, userId = response.userId)
            sessionManager.saveToken(token)
            Result.success(token)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getSavedToken(): AuthToken? {
        return sessionManager.getToken()
    }

    override suspend fun clearSession() {
        sessionManager.clear()
    }
}
