package com.example.tools2.model

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tools2.Clicker
import com.example.tools2.databinding.ItemBinding

sealed class MyRecyclerHolders (binding: ViewBinding) :  RecyclerView.ViewHolder(binding.root) {


    class FirstViewHolder(private val binding: ItemBinding) : MyRecyclerHolders(binding) {


        fun bind(item: DataClasses.Joke) {

            binding.punchline.text = item.punchline
            binding.setup.text = item.setup
            binding.root.setOnClickListener {
                Log.i("tag", "binding root")
            }



//
        }


    }




}