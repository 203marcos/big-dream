package com.bigdream.domain.model

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val headline: String = "",
    val skills: List<String> = emptyList(),
)
