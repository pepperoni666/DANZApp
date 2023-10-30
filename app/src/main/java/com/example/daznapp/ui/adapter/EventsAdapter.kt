package com.example.daznapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.daznapp.data.SportEvent

class EventsAdapter(private val onItemClickListener: ((SportEvent) -> Unit)? = null): ListAdapter<SportEvent, EventViewHolder>(EventDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(parent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }
}