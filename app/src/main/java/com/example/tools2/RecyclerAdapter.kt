package com.example.tools2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tools2.databinding.ItemBinding
import com.example.tools2.model.DataClasses
import com.example.tools2.model.MyRecyclerHolders

class RecyclerAdapter(val click:Clicker) : RecyclerView.Adapter<MyRecyclerHolders>() {

    private var items = mutableListOf<DataClasses>()

    fun setList(items:List<DataClasses>){
        this.items = items as MutableList<DataClasses>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerHolders {
        return when (viewType) {
            R.layout.item -> MyRecyclerHolders.FirstViewHolder(
                ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false), )

            else -> throw IllegalArgumentException("Invalid Type from adapter")
        }
    }

    override fun onBindViewHolder(holder: MyRecyclerHolders, position: Int) {
        when(holder){
            is MyRecyclerHolders.FirstViewHolder -> {
                holder.bind(items[position] as DataClasses.Joke)
                // тут реализуется делегирование при нажатии на клик срабатывает интерфейс туда передается дата
                holder.itemView.setOnClickListener{
                    click.itemClickListener(items[position])
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataClasses.Joke -> R.layout.item
            else -> super.getItemViewType(position)
        }


//        return super.getItemViewType(position)
    }
}