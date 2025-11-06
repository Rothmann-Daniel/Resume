package com.danielrothmann.dr.domain.models

data class Project(
    val id: Long,
    val name: String,
    val description: String,
    val technologies: List<String>,
    val githubUrl: String,
    val stars: Int? = 0,
    val forks: Int? = 0,
    val language: String? = null,
    val isFeatured: Boolean = false
)