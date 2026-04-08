package com.bigdream.domain.usecase

import com.bigdream.domain.model.AuthToken
import com.bigdream.domain.repository.AuthRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginUseCaseTest {

    private val fakeToken = AuthToken(accessToken = "fake-jwt", userId = 1L)

    @Test
    fun `login returns token on success`() = runTest {
        val repository = object : AuthRepository {
            override suspend fun login(email: String, password: String) = Result.success(fakeToken)
            override suspend fun register(name: String, email: String, password: String) = Result.success(fakeToken)
            override suspend fun getSavedToken() = fakeToken
            override suspend fun clearSession() {}
        }

        val useCase = LoginUseCase(repository)
        val result = useCase("test@email.com", "password123")

        assertTrue(result.isSuccess)
        assertEquals(fakeToken, result.getOrNull())
    }

    @Test
    fun `login returns failure on error`() = runTest {
        val repository = object : AuthRepository {
            override suspend fun login(email: String, password: String) = Result.failure<AuthToken>(RuntimeException("Network error"))
            override suspend fun register(name: String, email: String, password: String) = Result.success(fakeToken)
            override suspend fun getSavedToken() = null
            override suspend fun clearSession() {}
        }

        val useCase = LoginUseCase(repository)
        val result = useCase("test@email.com", "wrong")

        assertTrue(result.isFailure)
    }
}
