package io.github.chhabra_dhiraj.cameramusicapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.chhabra_dhiraj.cameramusicapp.databinding.ListItemBinding
import io.github.chhabra_dhiraj.cameramusicapp.domain.Song

class SongsAdapter : ListAdapter<Song, SongsAdapter.ViewHolder>(
    SongsDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Song
        ) {
            binding.song = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class SongsDiffCallback : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(
        oldItem: Song,
        newItem: Song
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Song,
        newItem: Song
    ): Boolean {
        return oldItem == newItem
    }
}