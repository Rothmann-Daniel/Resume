package com.danielrothmann.dr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.data.Experience
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ExperienceAdapter(
    private val experiences: List<Experience>
) : RecyclerView.Adapter<ExperienceAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCompany: TextView = itemView.findViewById(R.id.tvCompany)
        private val tvPosition: TextView = itemView.findViewById(R.id.tvPosition)
        private val tvPeriod: TextView = itemView.findViewById(R.id.tvPeriod)
        private val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
        private val tvSummary: TextView = itemView.findViewById(R.id.tvSummary)
        private val tvCurrentJob: TextView = itemView.findViewById(R.id.tvCurrentJob)
        private val chipGroup: ChipGroup = itemView.findViewById(R.id.chipGroupSkills)
        private val btnDetails: MaterialButton = itemView.findViewById(R.id.btnDetails)

        fun bind(experience: Experience) {
            tvCompany.text = experience.company
            tvPosition.text = experience.position
            tvPeriod.text = experience.period
            tvDuration.text = experience.duration
            tvSummary.text = experience.summary

            tvCurrentJob.visibility = if (experience.isCurrent) View.VISIBLE else View.GONE

            chipGroup.removeAllViews()
            experience.skills.forEach { skill ->
                val chip = Chip(itemView.context).apply {
                    text = skill
                    isCheckable = false
                    isClickable = false
                    setChipBackgroundColorResource(com.google.android.material.R.color.m3_chip_background_color)
                    setTextAppearanceResource(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
                    chipStrokeWidth = 1f
                }
                chipGroup.addView(chip)
            }

            btnDetails.setOnClickListener {
                showExperienceDetails(experience)
            }
        }

        private fun showExperienceDetails(experience: Experience) {
            val dialogView = LayoutInflater.from(itemView.context)
                .inflate(R.layout.dialog_experience_details, null)

            val tvDetailCompany: TextView = dialogView.findViewById(R.id.tvDetailCompany)
            val tvDetailPosition: TextView = dialogView.findViewById(R.id.tvDetailPosition)
            val tvDetailPeriod: TextView = dialogView.findViewById(R.id.tvDetailPeriod)
            val tvDetailDescription: TextView = dialogView.findViewById(R.id.tvDetailDescription)
            val layoutAchievements: LinearLayout = dialogView.findViewById(R.id.layoutAchievements)
            val chipGroupDetail: ChipGroup = dialogView.findViewById(R.id.chipGroupDetailSkills)

            tvDetailCompany.text = experience.company
            tvDetailPosition.text = experience.position
            tvDetailPeriod.text = "${experience.period} • ${experience.duration}"
            tvDetailDescription.text = experience.fullDescription

            layoutAchievements.removeAllViews()
            experience.achievements.forEach { achievement ->
                val achievementView = LayoutInflater.from(itemView.context)
                    .inflate(android.R.layout.simple_list_item_1, layoutAchievements, false)
                val textView = achievementView as TextView
                textView.text = "• $achievement"
                textView.setTextSize(14f)
                textView.setLineSpacing(4f, 1f)
                layoutAchievements.addView(achievementView)
            }

            chipGroupDetail.removeAllViews()
            experience.skills.forEach { skill ->
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
            .inflate(R.layout.item_experience, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(experiences[position])
    }

    override fun getItemCount() = experiences.size
}