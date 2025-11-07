package com.danielrothmann.dr.ui.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielrothmann.dr.databinding.FragmentProjectsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectsFragment : Fragment() {

    private var _binding: FragmentProjectsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProjectsViewModel by viewModel()
    private lateinit var adapter: ProjectsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView() // Инициализируем адаптер один раз
        observeViewModel()  // Подписываемся на данные
    }

    private fun setupRecyclerView() {
        adapter = ProjectsAdapter() // Создаем адаптер один раз
        binding.projectsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ProjectsFragment.adapter // Привязываем
        }
    }

    private fun observeViewModel() {
        viewModel.projects.observe(viewLifecycleOwner) { projects ->
            adapter.updateData(projects) //  Обновляем данные в существующем адаптере
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}