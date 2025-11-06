package com.danielrothmann.dr.ui.skills

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielrothmann.dr.R
import com.danielrothmann.dr.domain.models.Recommendation

class RecommendationsAdapter(
    private val recommendationsList: List<Recommendation>
) : RecyclerView.Adapter<RecommendationsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvPosition: TextView = itemView.findViewById(R.id.tvPosition)
        private val tvCompany: TextView = itemView.findViewById(R.id.tvCompany)
        private val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)

        fun bind(recommendation: Recommendation) {
            tvName.text = recommendation.name
            tvPosition.text = recommendation.position
            tvCompany.text = recommendation.company
            tvPhone.text = recommendation.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommendation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recommendationsList[position])
    }

    override fun getItemCount() = recommendationsList.size
}