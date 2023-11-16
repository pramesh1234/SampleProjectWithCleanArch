package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.R
import com.example.myapplication.model.Data

class InPlayListAdapter : ListAdapter<Data, InPlayListAdapter.InPlayListViewHolder>(Comparator) {
   inner class InPlayListViewHolder(itemView: View) : ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.tvEventName)

        fun bind(item: Data) {
            textView.text = item.eventName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InPlayListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_in_play, parent, false)
        return InPlayListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: InPlayListViewHolder, position: Int) {
        val currentItem = getItem(position)
        currentItem?.let {
            holder.bind(item = it)
    }
}
}
private val Comparator = object : DiffUtil.ItemCallback<Data>() {

    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
       return oldItem.id == newItem.id

    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem

    }
}


