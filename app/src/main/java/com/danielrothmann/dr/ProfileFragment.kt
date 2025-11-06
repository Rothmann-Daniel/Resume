package com.danielrothmann.dr

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.danielrothmann.dr.databinding.FragmentProfileBinding
import com.danielrothmann.dr.domain.util.EmailUtils

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.tvNameProfile.text = getString(R.string.developer)
        binding.tvEmailProfile.text = getString(R.string.gmail)
        binding.tvPhoneProfile.text = getString(R.string.mobile_phone)
        binding.tvGit.text = getString(R.string.github_daniel)

        // Программно устанавливаем флаг подчеркивания
        binding.tvEmailProfile.paintFlags = binding.tvEmailProfile.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.tvPhoneProfile.paintFlags = binding.tvPhoneProfile.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        binding.tvGit.paintFlags = binding.tvGit.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        // Обработка клика по email
        binding.tvEmailProfile.setOnClickListener {
            EmailUtils.sendEmail(requireContext())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}