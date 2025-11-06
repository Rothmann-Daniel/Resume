package com.danielrothmann.dr.ui.experience


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielrothmann.dr.databinding.FragmentExperienceBinding
import org.koin.androidx.viewmodel.ext.android.viewModel




class ExperienceFragment : Fragment() {

    private var _binding: FragmentExperienceBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExperienceViewModel by viewModel()
    private lateinit var adapter: ExperienceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = ExperienceAdapter(emptyList())
        binding.experienceRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ExperienceFragment.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.experiences.observe(viewLifecycleOwner) { experiences ->
            adapter = ExperienceAdapter(experiences)
            binding.experienceRecyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.experienceRecyclerView.adapter = null
        _binding = null
    }
}