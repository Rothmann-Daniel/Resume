package com.danielrothmann.dr.domain.models

data class Skill(
    val id: Long,
    val category: String,
    val skills: List<String>,
    val iconRes: Int? = null
)