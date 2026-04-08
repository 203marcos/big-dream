package com.bigdream.domain.model

data class AuthToken(
    val accessToken: String,
    val userId: Long,
)
