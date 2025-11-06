package com.danielrothmann.dr.domain.models

data class Recommendation(
    val id: Long,
    val name: String,
    val position: String,
    val company: String,
    val phone: String? = null,
    val email: String? = null
)