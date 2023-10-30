package com.example.daznapp.ui.adapter

import android.text.format.DateUtils
import android.text.format.DateUtils.DAY_IN_MILLIS
import android.text.format.DateUtils.WEEK_IN_MILLIS
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daznapp.data.SportEvent
import com.example.daznapp.databinding.RowEventBinding
import com.example.daznapp.ui.DateHelper.isoToTimestamp

class EventViewHolder(
    parent: ViewGroup,
    private val binding: RowEventBinding = RowEventBinding.inflate(
        LayoutInflater.from(
            parent.context
        ), parent, false
    )
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: SportEvent, onItemClickListener: ((SportEvent) -> Unit)?) {
        binding.apply {
            title.text = data.title
            subtitle.text = data.subtitle
            date.text = DateUtils.getRelativeDateTimeString(
                binding.root.context,
                isoToTimestamp(data.date),
                DAY_IN_MILLIS,
                WEEK_IN_MILLIS,
                0
            )
            Glide.with(binding.root).load(data.imageUrl).into(binding.image)
            onItemClickListener?.let { listener ->
                root.setOnClickListener { listener(data) }
            }
        }
    }
}