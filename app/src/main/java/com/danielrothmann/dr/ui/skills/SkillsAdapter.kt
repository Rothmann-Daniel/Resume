package com.danielrothmann.dr.ui.skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.models.Skill
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SkillsAdapter(
    private val skillsList: List<Skill>
) : RecyclerView.Adapter<SkillsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCategory: TextView = itemView.findViewById(R.id.tvCategory)
        private val chipGroup: ChipGroup = itemView.findViewById(R.id.chipGroupSkills)

        fun bind(skill: Skill) {
            tvCategory.text = skill.category

            chipGroup.removeAllViews()
            skill.skills.forEach { skillItem ->
                val chip = LayoutInflater.from(itemView.context)
                    .inflate(R.layout.item_chip, chipGroup, false) as Chip
                chip.apply {
                    text = skillItem
                    isCheckable = false
                    isClickable = false
                }
                chipGroup.addView(chip)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_skill_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(skillsList[position])
    }

    override fun getItemCount() = skillsList.size
}