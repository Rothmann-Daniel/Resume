package com.danielrothmann.dr.domain.repository

import com.danielrothmann.dr.domain.models.Education
import com.danielrothmann.dr.domain.models.Experience
import com.danielrothmann.dr.domain.models.PersonalInfo
import com.danielrothmann.dr.domain.models.Project
import com.danielrothmann.dr.domain.models.Recommendation
import com.danielrothmann.dr.domain.models.Skill

interface ProfileRepository {
    fun getExperiences(): List<Experience>
    fun getEducation(): List<Education>
    fun getProjects(): List<Project>
    fun getSkills(): List<Skill>
    fun getRecommendations(): List<Recommendation>
    fun getPersonalInfo(): PersonalInfo
}
