package com.bigdream.domain.repository

import com.bigdream.domain.model.AuthToken

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<AuthToken>
    suspend fun register(name: String, email: String, password: String): Result<AuthToken>
    suspend fun getSavedToken(): AuthToken?
    suspend fun clearSession()
}
