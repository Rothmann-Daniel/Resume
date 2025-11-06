package com.danielrothmann.dr.ui.education

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielrothmann.dr.domain.models.Education
import com.danielrothmann.dr.domain.repository.ProfileRepository

class EducationViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    private val _education = MutableLiveData<List<Education>>()
    val education: LiveData<List<Education>> = _education

    init {
        loadEducation()
    }

    private fun loadEducation() {
        _education.value = repository.getEducation()
    }
}
