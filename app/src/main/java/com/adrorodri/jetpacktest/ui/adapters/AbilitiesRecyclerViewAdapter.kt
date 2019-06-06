package com.adrorodri.jetpacktest.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adrorodri.jetpacktest.R
import com.adrorodri.jetpacktest.domain.entities.Ability

class AbilitiesRecyclerViewAdapter(
    private val context: Context,
    private var abilitiesList: MutableList<Ability>,
    private var onAbilityClickListener: (ability: Ability) -> Unit
) : RecyclerView.Adapter<AbilitiesRecyclerViewAdapter.AbilitiesViewHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_ability_item, null)
        return AbilitiesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return abilitiesList.size
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        holder.tvAbility.text = abilitiesList[position].name
        holder.itemView.setOnClickListener { onAbilityClickListener(abilitiesList[position]) }
    }

    fun setItems(results: List<Ability>?) {
        this.abilitiesList = results as MutableList<Ability>
        notifyDataSetChanged()
    }

    class AbilitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAbility: TextView = itemView.findViewById(R.id.tvAbility)
    }
}