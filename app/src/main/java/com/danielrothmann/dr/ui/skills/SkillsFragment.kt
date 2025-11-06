package com.danielrothmann.dr.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.danielrothmann.dr.databinding.FragmentSkillsBinding
import com.danielrothmann.dr.databinding.BottomSheetPersonalInfoBinding
import com.danielrothmann.dr.domain.models.PersonalInfo
import com.danielrothmann.dr.domain.models.Recommendation
import com.danielrothmann.dr.domain.models.Skill

class SkillsFragment : Fragment() {

    private var _binding: FragmentSkillsBinding? = null
    private val binding get() = _binding!!
    private lateinit var skillsAdapter: SkillsAdapter
    private lateinit var recommendationsAdapter: RecommendationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSkillsRecyclerView()
        setupRecommendationsRecyclerView()
        setupPersonalInfoButton()
    }

    private fun setupSkillsRecyclerView() {
        skillsAdapter = SkillsAdapter(getSkillsList())
        binding.skillsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = skillsAdapter
        }
    }

    private fun setupRecommendationsRecyclerView() {
        recommendationsAdapter = RecommendationsAdapter(getRecommendationsList())
        binding.recommendationsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = recommendationsAdapter
        }
    }

    private fun setupPersonalInfoButton() {
        binding.btnPersonalInfo.setOnClickListener {
            showPersonalInfoBottomSheet()
        }
    }

    private fun showPersonalInfoBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetPersonalInfoBinding.inflate(layoutInflater)

        val personalInfo = getPersonalInfo()

        // логирование для отладки
        println("DEBUG: About text length = ${personalInfo.about.length}")
        println("DEBUG: Hobbies text length = ${personalInfo.hobbies.length}")
        println("DEBUG: CareerPath text = ${personalInfo.careerPath}")

        bottomSheetBinding.tvAbout.text = personalInfo.about
        bottomSheetBinding.tvHobbies.text = personalInfo.hobbies
        bottomSheetBinding.tvCareerPath.text = personalInfo.careerPath

        bottomSheetBinding.btnClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(bottomSheetBinding.root)
        dialog.show()
    }

    private fun getSkillsList(): List<Skill> {
        return listOf(
            Skill(
                id = 1,
                category = "Backend & Networking",
                skills = listOf(
                    "Retrofit 2 - для сетевых запросов к API",
                    "Gson - для парсинга JSON ответов",
                    "OkHttp3 - HTTP клиент с логированием запросов",
                    "Coil - для загрузки и кэширования изображений"
                )
            ),
            Skill(
                id = 2,
                category = "Architecture & DI",
                skills = listOf(
                    "Kotlin - основной язык разработки",
                    "MVVM - архитектурный паттерн",
                    "Koin - dependency injection",
                    "Single Activity + Fragments - навигация",
                    "Jetpack Navigation Component - управление навигацией",
                    "Lifecycle & ViewModel - управление жизненным циклом"
                )
            ),
            Skill(
                id = 3,
                category = "Async & Data",
                skills = listOf(
                    "Coroutines - асинхронные операции",
                    "Flow - реактивные потоки данных",
                    "Room Database - локальное хранилище"
                )
            ),
            Skill(
                id = 4,
                category = "UI",
                skills = listOf(
                    "XML Layouts",
                    "Material Design - современный UI",
                    "ViewBinding - привязка view",
                    "AndroidX - современные компоненты",
                    "ViewPager2 - для swipe интерфейсов"
                )
            ),
            Skill(
                id = 5,
                category = "Личные качества",
                skills = listOf(
                    "Коммуникабельность",
                    "Нестандартное мышление",
                    "Лидерство",
                    "Стратегическое планирование",
                    "Управление проектами",
                    "Техническая экспертиза"
                )
            )
        )
    }

    private fun getRecommendationsList(): List<Recommendation> {
        return listOf(
            Recommendation(
                id = 1,
                name = "Березовский Артем Арнольдович",
                position = "Заместитель генерального директора",
                company = "ООО \"ПетроСтрой\"",
                //phone = "+79317777777"
            ),
            Recommendation(
                id = 2,
                name = "Лесов Александр Владимирович",
                position = "Региональный директор",
                company = "ООО \"Корвет\""
            ),
            Recommendation(
                id = 3,
                name = "Гольцов Сергей Викторович",
                position = "Генеральный директор",
                company = "Холдинг NEO и НПО \"Тюменькриобанк\""
            ),
            Recommendation(
                id = 4,
                name = "Москалюк Роман Сергеевич",
                position = "Генеральный директор",
                company = "ООО \"Криомедтех\" (ООО \"Криогентех\")"
            )
        )
    }

    private fun getPersonalInfo(): PersonalInfo {
        return PersonalInfo.DEFAULT
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}