package com.vagner.live.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vagner.live.databinding.ItemLiveBinding
import com.vagner.live.models.LiveItem

class LiveAdapte(
    val onClickListener: (LiveItem) -> Unit
) :
    RecyclerView.Adapter<LiveAdapte.LiveViewHolder>() {

    var lives = emptyList<LiveItem>()
        set(value) {
           field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = lives.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        return LiveViewHolder(
            ItemLiveBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {
        holder.bind(lives[position])
        holder.binding.cardLive.setOnClickListener {
            onClickListener(lives[position])
        }
    }


    inner class LiveViewHolder(val binding: ItemLiveBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(live: LiveItem) {
            binding.textAuthor.text = live.author
            binding.textTitle.text = live.title

            Glide.with(binding.imageThumbnail)
                .load(live.thumbnailUrl)
                .centerInside()
                .into(binding.imageThumbnail)
        }

    }

}