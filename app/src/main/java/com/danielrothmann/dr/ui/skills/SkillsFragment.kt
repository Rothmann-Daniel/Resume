package com.danielrothmann.dr.ui.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielrothmann.dr.databinding.BottomSheetPersonalInfoBinding
import com.danielrothmann.dr.databinding.FragmentSkillsBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class SkillsFragment : Fragment() {

    private var _binding: FragmentSkillsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SkillsViewModel by viewModel()
    private lateinit var skillsAdapter: SkillsAdapter
    private lateinit var recommendationsAdapter: RecommendationsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSkillsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerViews()
        setupPersonalInfoButton()
        observeViewModel()
    }

    private fun setupRecyclerViews() {
        skillsAdapter = SkillsAdapter(emptyList())
        binding.skillsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = skillsAdapter
        }

        recommendationsAdapter = RecommendationsAdapter(emptyList())
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

    private fun observeViewModel() {
        viewModel.skills.observe(viewLifecycleOwner) { skills ->
            skillsAdapter = SkillsAdapter(skills)
            binding.skillsRecyclerView.adapter = skillsAdapter
        }

        viewModel.recommendations.observe(viewLifecycleOwner) { recommendations ->
            recommendationsAdapter = RecommendationsAdapter(recommendations)
            binding.recommendationsRecyclerView.adapter = recommendationsAdapter
        }
    }

    private fun showPersonalInfoBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        val bottomSheetBinding = BottomSheetPersonalInfoBinding.inflate(layoutInflater)

        viewModel.personalInfo.observe(viewLifecycleOwner) { personalInfo ->
            bottomSheetBinding.tvAbout.text = personalInfo.about
            bottomSheetBinding.tvHobbies.text = personalInfo.hobbies
            bottomSheetBinding.tvCareerPath.text = personalInfo.careerPath
        }

        bottomSheetBinding.btnClose.setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(bottomSheetBinding.root)
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.skillsRecyclerView.adapter = null
        binding.recommendationsRecyclerView.adapter = null
        _binding = null
    }
}
