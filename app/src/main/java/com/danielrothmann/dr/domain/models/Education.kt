package com.danielrothmann.dr.domain.models

data class Education(
    val id: Long,
    val institution: String,
    val specialty: String,
    val period: String,
    val description: String,
    val type: EducationType,
    val skills: List<String> = emptyList()
)

enum class EducationType {
    HIGHER, COLLEGE, COURSE, CERTIFICATION, SELF_EDUCATION
}