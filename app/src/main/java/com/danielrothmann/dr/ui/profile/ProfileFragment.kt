package com.danielrothmann.dr.ui.profile

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import com.danielrothmann.dr.R
import com.danielrothmann.dr.databinding.FragmentProfileBinding
import com.danielrothmann.dr.domain.util.EmailUtils
import java.io.File
import java.io.FileOutputStream

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

        binding.btnShareResume.setOnClickListener {
            shareResumePdf()
        }
    }

    private fun shareResumePdf() {
        try {
            val pdfUri = getPdfFromRaw()
            Log.d("ProfileFragment", "PDF URI: $pdfUri")

            if (pdfUri != null) {
                sharePdfFile(pdfUri)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Файл резюме не найден",
                    Toast.LENGTH_SHORT
                ).show()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(
                requireContext(),
                "Ошибка: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun sharePdfFile(uri: Uri) {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/pdf"
            putExtra(Intent.EXTRA_STREAM, uri)
            putExtra(Intent.EXTRA_SUBJECT, "Резюме: Android-разработчик Данила Ротман")
            putExtra(Intent.EXTRA_TEXT, "Во вложении, файл с резюме Android разработчика Данилы Ротмана")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        try {
            startActivity(Intent.createChooser(shareIntent, "Поделиться резюме"))
        } catch (e: Exception) {
            Toast.makeText(
                requireContext(),
                "Не найдено приложение для отправки файла",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun getPdfFromRaw(): Uri? {
        return try {
            // Проверяем существование raw ресурса
            val resourceId = R.raw.resume_daniel_rothmann
            val inputStream = resources.openRawResource(resourceId)

            // Создаем файл в кэш директории
            val cacheDir = requireContext().cacheDir
            val file = File(cacheDir, "resume_daniel_rothmann.pdf")

            // Копируем файл из raw ресурсов
            FileOutputStream(file).use { output ->
                inputStream.copyTo(output)
            }

            Log.d("ProfileFragment", "File created: ${file.absolutePath}")
            Log.d("ProfileFragment", "File exists: ${file.exists()}")
            Log.d("ProfileFragment", "File size: ${file.length()} bytes")

            // Получаем URI через FileProvider
            FileProvider.getUriForFile(
                requireContext(),
                "${requireContext().packageName}.fileprovider",
                file
            )
        } catch (e: Exception) {
            Log.e("ProfileFragment", "Error creating PDF file", e)
            null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}