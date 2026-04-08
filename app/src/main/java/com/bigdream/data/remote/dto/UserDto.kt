package com.bigdream.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
    val headline: String = "",
    val skills: List<String> = emptyList(),
)
