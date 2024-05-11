package com.example.list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.University
import com.example.list.R
import com.example.list.databinding.ItemUniversityBinding

class UniversitiesAdapter : ListAdapter<University, UniversitiesAdapter.ViewHolder>(OffersDiffCallback()) {
    internal var select: (University) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ItemUniversityBinding.bind(holder.itemView)
        holder.bind(getItem(position), binding, select)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: University, binding: ItemUniversityBinding, select: (University) -> Unit) {
            binding.tvName.text = item.name
            binding.tvState.text = item.stateProvince
            binding.root.setOnClickListener { select(item) }
        }
    }
}

class OffersDiffCallback : DiffUtil.ItemCallback<University>() {
    override fun areItemsTheSame(oldItem: University, newItem: University): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: University, newItem: University): Boolean {
        return oldItem == newItem
    }
}