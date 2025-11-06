package com.danielrothmann.dr.ui.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danielrothmann.dr.domain.models.Project
import com.danielrothmann.dr.domain.repository.ProfileRepository

class ProjectsViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    private val _projects = MutableLiveData<List<Project>>()
    val projects: LiveData<List<Project>> = _projects

    init {
        loadProjects()
    }

    private fun loadProjects() {
        _projects.value = repository.getProjects()
    }
}