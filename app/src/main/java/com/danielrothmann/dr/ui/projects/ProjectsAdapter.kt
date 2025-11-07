package com.danielrothmann.dr.ui.projects

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.models.Project
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ProjectsAdapter(
    private var projectsList: List<Project> = emptyList()
) : RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {

    // Метод для обновления данных
    fun updateData(newProjects: List<Project>) {
        val diffResult = DiffUtil.calculateDiff(ProjectDiffCallback(projectsList, newProjects))
        projectsList = newProjects
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvProjectName: TextView = itemView.findViewById(R.id.tvProjectName)
        private val tvProjectDescription: TextView = itemView.findViewById(R.id.tvProjectDescription)
        private val tvLanguage: TextView = itemView.findViewById(R.id.tvLanguage)
        private val tvStars: TextView = itemView.findViewById(R.id.tvStars)
        private val tvForks: TextView = itemView.findViewById(R.id.tvForks)
        private val chipGroupTechnologies: ChipGroup = itemView.findViewById(R.id.chipGroupTechnologies)
        private val btnGithub: MaterialButton = itemView.findViewById(R.id.btnGithub)

        fun bind(project: Project) {
            tvProjectName.text = project.name
            tvProjectDescription.text = project.description
            tvLanguage.text = project.language ?: "Kotlin"
            tvStars.text = project.stars.toString()
            tvForks.text = project.forks.toString()

            // Очищаем и добавляем технологии через кастомный layout
            chipGroupTechnologies.removeAllViews()
            project.technologies.forEach { tech ->
                val chip = LayoutInflater.from(itemView.context)
                    .inflate(R.layout.item_chip, chipGroupTechnologies, false) as Chip
                chip.apply {
                    text = tech
                    isCheckable = false
                    isClickable = false
                }
                chipGroupTechnologies.addView(chip)
            }

            // Обработчик клика по кнопке GitHub
            btnGithub.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(project.githubUrl))
                itemView.context.startActivity(intent)
            }

            // Выделяем избранные проекты
            if (project.isFeatured) {
                itemView.alpha = 1.0f
            } else {
                itemView.alpha = 0.9f
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_project, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(projectsList[position])
    }

    override fun getItemCount() = projectsList.size
}

class ProjectDiffCallback(
    private val oldList: List<Project>,
    private val newList: List<Project>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int): Boolean {
        return oldList[oldPos].id == newList[newPos].id
    }

    override fun areContentsTheSame(oldPos: Int, newPos: Int): Boolean {
        return oldList[oldPos] == newList[newPos]
    }
}