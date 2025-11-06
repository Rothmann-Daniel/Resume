package com.danielrothmann.dr.ui.experience

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielrothmann.dr.domain.models.Experience
import com.danielrothmann.dr.domain.repository.ProfileRepository

class ExperienceViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    private val _experiences = MutableLiveData<List<Experience>>()
    val experiences: LiveData<List<Experience>> = _experiences

    init {
        loadExperiences()
    }

    private fun loadExperiences() {
        _experiences.value = repository.getExperiences()
    }
}
