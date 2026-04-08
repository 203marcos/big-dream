package com.bigdream.domain.usecase

import com.bigdream.domain.model.AuthToken
import com.bigdream.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(email: String, password: String): Result<AuthToken> {
        return authRepository.login(email, password)
    }
}
