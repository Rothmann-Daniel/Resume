package com.danielrothmann.dr.di

import com.danielrothmann.dr.data.repository.ProfileRepositoryImpl
import com.danielrothmann.dr.domain.repository.ProfileRepository
import com.danielrothmann.dr.ui.education.EducationViewModel
import com.danielrothmann.dr.ui.experience.ExperienceViewModel
import com.danielrothmann.dr.ui.projects.ProjectsViewModel
import com.danielrothmann.dr.ui.skills.SkillsViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Repository
    single<ProfileRepository> { ProfileRepositoryImpl() }

    // ViewModels
    viewModel { ExperienceViewModel(get()) }
    viewModel { EducationViewModel(get()) }
    viewModel { ProjectsViewModel(get()) }
    viewModel { SkillsViewModel(get()) }
}
