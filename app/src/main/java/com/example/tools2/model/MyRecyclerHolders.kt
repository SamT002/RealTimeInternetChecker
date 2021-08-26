package com.example.tools2.model

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tools2.databinding.ItemBinding

sealed class MyRecyclerHolders (binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class FirstViewHolder(private val binding: ItemBinding) : MyRecyclerHolders(binding) {

        fun bind(item: DataClasses.Joke) {

            binding.punchline.text = item.punchline
            binding.setup.text = item.setup
        }

    }
}