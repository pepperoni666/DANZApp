package com.example.daznapp.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.daznapp.data.SportEvent

class EventDiffItemCallback : DiffUtil.ItemCallback<SportEvent>() {

    override fun areItemsTheSame(oldItem: SportEvent, newItem: SportEvent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SportEvent, newItem: SportEvent): Boolean {
        return newItem.title == oldItem.title &&
                newItem.subtitle == oldItem.subtitle &&
                newItem.imageUrl == oldItem.imageUrl
    }
}
