package com.danielrothmann.dr.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielrothmann.dr.databinding.FragmentProjectsBinding
import com.danielrothmann.dr.domain.models.Project

class ProjectsFragment : Fragment() {

    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!
    private lateinit var projectsAdapter: ProjectsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupProjectsRecyclerView()
    }

    private fun setupProjectsRecyclerView() {
        projectsAdapter = ProjectsAdapter(getProjectsList())
        binding.projectsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = projectsAdapter
        }
    }

    private fun getProjectsList(): List<Project> {
        return listOf(
            Project(
                id = 1,
                name = "PlayList Maker",
                description = "Android приложение для проигрывания музыки с современным UI и поддержкой локальных файлов. Реализовано с использованием MVVM, Room, iTunes API.",
                technologies = listOf("Kotlin", "MVVM", "Room", "MediaPlayer", "Coroutines", "ViewBinding", "SingleActivity", "Retrofit", "Gson", "Coil", "Koin DI", "SingleActivity", "Lifecycle & ViewModel"),
                githubUrl = "https://github.com/Rothmann-Daniel/Playlist-Maker",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = true
            ),
            Project(
                id = 2,
                name = "WeatherApp",
                description = "Android приложение для просмотра текущей погоды, просмотр прогноза на 5 дней, смена локаций.",
                technologies = listOf("Kotlin", "Volley(исп. альтернатива Retrofit)", "OpenWeather API", "Location Services", "SingleActivity", "LiveData", "Gson", "Picasso"),
                githubUrl = "https://github.com/Rothmann-Daniel/WeatherApp",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            ),
            Project(
                id = 3,
                name = "FoodDeliveryApp: BasketBite",
                description = "Android приложение для заказа и доставки еды с возможностью выбора из разнообразного меню и интеграции с различными ресторанами.",
                technologies = listOf("Kotlin", "Room", "ViewPager2", "Koin DI", "Favorites"),
                githubUrl = "https://github.com/Rothmann-Daniel/FoodDeliveryApp",
                stars = 0,
                forks = 0,
                language = "Kotlin",
                isFeatured = false
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
