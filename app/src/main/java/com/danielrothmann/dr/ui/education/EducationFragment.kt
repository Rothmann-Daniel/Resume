
package com.danielrothmann.dr.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.danielrothmann.dr.databinding.FragmentEducationBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!

    private val viewModel: EducationViewModel by viewModel()
    private lateinit var adapter: EducationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        adapter = EducationAdapter(emptyList())
        binding.educationRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@EducationFragment.adapter
        }
    }

    private fun observeViewModel() {
        viewModel.education.observe(viewLifecycleOwner) { education ->
            adapter = EducationAdapter(education)
            binding.educationRecyclerView.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.educationRecyclerView.adapter = null
        _binding = null
    }
}