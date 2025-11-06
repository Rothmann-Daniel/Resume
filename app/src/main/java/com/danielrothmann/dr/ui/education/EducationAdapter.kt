package com.danielrothmann.dr.ui.education

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.models.Education
import com.danielrothmann.dr.domain.models.EducationType
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EducationAdapter(
    private val educationList: List<Education>
) : RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvInstitution: TextView = itemView.findViewById(R.id.tvInstitution)
        private val tvSpecialty: TextView = itemView.findViewById(R.id.tvSpecialty)
        private val tvPeriod: TextView = itemView.findViewById(R.id.tvPeriod)
        private val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        private val tvType: TextView = itemView.findViewById(R.id.tvType)
        private val chipGroup: ChipGroup = itemView.findViewById(R.id.chipGroupSkills)
        private val btnDetails: MaterialButton = itemView.findViewById(R.id.btnDetails)

        fun bind(education: Education) {
            tvInstitution.text = education.institution
            tvSpecialty.text = education.specialty
            tvPeriod.text = education.period
            tvDescription.text = education.description
            tvType.text = getTypeString(education.type)

            chipGroup.removeAllViews()
            education.skills.forEach { skill ->
                val chip = Chip(itemView.context).apply {
                    text = skill
                    isCheckable = false
                    isClickable = false
                    setChipBackgroundColorResource(com.google.android.material.R.color.m3_chip_background_color)
                    setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                    chipStrokeWidth = 1f
                }
                chipGroup.addView(chip)
            }

            btnDetails.setOnClickListener {
                showEducationDetails(education)
            }
        }

        private fun getTypeString(type: EducationType): String {
            return when (type) {
                EducationType.HIGHER -> "Высшее образование"
                EducationType.COLLEGE -> "Среднее специальное"
                EducationType.COURSE -> "Курсы повышения квалификации"
                EducationType.CERTIFICATION -> "Сертификация"
                EducationType.SELF_EDUCATION -> "Профессиональная переподготовка"
            }
        }

        private fun showEducationDetails(education: Education) {
            val dialogView = LayoutInflater.from(itemView.context)
                .inflate(R.layout.dialog_education_details, null)

            val tvDetailInstitution: TextView = dialogView.findViewById(R.id.tvDetailInstitution)
            val tvDetailSpecialty: TextView = dialogView.findViewById(R.id.tvDetailSpecialty)
            val tvDetailPeriod: TextView = dialogView.findViewById(R.id.tvDetailPeriod)
            val tvDetailType: TextView = dialogView.findViewById(R.id.tvDetailType)
            val tvDetailDescription: TextView = dialogView.findViewById(R.id.tvDetailDescription)
            val chipGroupDetail: ChipGroup = dialogView.findViewById(R.id.chipGroupDetailSkills)

            tvDetailInstitution.text = education.institution
            tvDetailSpecialty.text = education.specialty
            tvDetailPeriod.text = education.period
            tvDetailType.text = getTypeString(education.type)
            tvDetailDescription.text = education.description

            chipGroupDetail.removeAllViews()
            education.skills.forEach { skill ->
                val chip = Chip(itemView.context).apply {
                    text = skill
                    isCheckable = false
                    isClickable = false
                    setChipBackgroundColorResource(com.google.android.material.R.color.m3_chip_background_color)
                }
                chipGroupDetail.addView(chip)
            }

            MaterialAlertDialogBuilder(itemView.context)
                .setView(dialogView)
                .setPositiveButton("Закрыть") { dialog, _ -> dialog.dismiss() }
                .show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_education, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(educationList[position])
    }

    override fun getItemCount() = educationList.size
}