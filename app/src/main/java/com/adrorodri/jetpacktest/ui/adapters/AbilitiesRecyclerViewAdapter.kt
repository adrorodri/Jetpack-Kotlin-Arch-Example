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

class AbilitiesRecyclerViewAdapter(private val context: Context, private var abilitiesList: MutableList<Ability>) :
    RecyclerView.Adapter<AbilitiesRecyclerViewAdapter.ViewHolder>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_ability_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return abilitiesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAbility.text = abilitiesList[position].name
    }

    fun setItems(results: List<Ability>?) {
        this.abilitiesList = results as MutableList<Ability>
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAbility: TextView = itemView.findViewById(R.id.tvAbility)
    }
}