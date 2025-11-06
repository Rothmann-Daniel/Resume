package com.danielrothmann.dr.ui.skills

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielrothmann.dr.domain.models.PersonalInfo
import com.danielrothmann.dr.domain.models.Recommendation
import com.danielrothmann.dr.domain.models.Skill
import com.danielrothmann.dr.domain.repository.ProfileRepository

class SkillsViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    private val _skills = MutableLiveData<List<Skill>>()
    val skills: LiveData<List<Skill>> = _skills

    private val _recommendations = MutableLiveData<List<Recommendation>>()
    val recommendations: LiveData<List<Recommendation>> = _recommendations

    private val _personalInfo = MutableLiveData<PersonalInfo>()
    val personalInfo: LiveData<PersonalInfo> = _personalInfo

    init {
        loadData()
    }

    private fun loadData() {
        _skills.value = repository.getSkills()
        _recommendations.value = repository.getRecommendations()
        _personalInfo.value = repository.getPersonalInfo()
    }
}