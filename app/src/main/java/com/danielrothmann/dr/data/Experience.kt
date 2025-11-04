package com.danielrothmann.dr.data

data class Experience(
    val id: Long,
    val company: String,
    val position: String,
    val period: String,
    val duration: String,
    val summary: String,
    val skills: List<String>,
    val fullDescription: String,
    val achievements: List<String>,
    val isCurrent: Boolean = false
)