package com.example.tools2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tools2.databinding.ActivityMainBinding
import com.example.tools2.repository.Repository
import com.example.tools2.retrofit.MyRequest
import com.example.tools2.viewModel.HomeViewModel
import com.example.tools2.viewModel.MyViewModelFactory
import net.simplifiedcoding.multiviewlist.data.network.Resource

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter:RecyclerAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myAdapter = RecyclerAdapter()
        viewModel =  ViewModelProvider(this, MyViewModelFactory()).get(HomeViewModel::class.java)
        setUpRecycler()

        viewModel.homeList.observe(this, Observer { result ->
            when(result){
                is Resource.Success ->{
                    myAdapter.setList(result.value)
                    binding.progress.visibility = View.GONE
                }
                is Resource.Failure -> Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show()
                Resource.Loading -> binding.progress.visibility = View.VISIBLE
            }
        })



    }

    private fun setUpRecycler() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
    }
}