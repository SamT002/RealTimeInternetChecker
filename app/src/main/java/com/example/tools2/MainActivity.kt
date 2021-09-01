package com.example.tools2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytools.ConnectionLiveData
import com.example.tools2.databinding.ActivityMainBinding
import com.example.tools2.model.DataClasses
import com.example.tools2.model.MyRecyclerHolders
import com.example.tools2.viewModel.HomeViewModel
import com.example.tools2.viewModel.MyViewModelFactory
import com.example.tools2.model.Resource
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : BaseActivity(R.layout.activity_main),Clicker {

    private lateinit var binding: ActivityMainBinding

    private lateinit var myAdapter:RecyclerAdapter

    private lateinit var viewModel: HomeViewModel


    override fun refresh() {
        viewModel.getHomeListItems()
    }

    override fun setupUi() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myAdapter = RecyclerAdapter(this)
        viewModel =  ViewModelProvider(this, MyViewModelFactory()).get(HomeViewModel::class.java)
        internetCheck(binding.recycler)
    }

    override fun observDataFromHomeViewModel() {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myAdapter
        }
        Log.i("TAG", "onCreate from baseActivity")
        viewModel.homeList.observe(this, Observer {result ->
            when(result){
                is Resource.Failure -> TODO()
                Resource.Loading -> {
                   /* binding.spinner.setIndeterminateDrawable(DoubleBounce())
                    binding.spinner2.setIndeterminateDrawable(DoubleBounce())
                    binding.spinner3.setIndeterminateDrawable(DoubleBounce())
                    binding.spinner4.setIndeterminateDrawable(DoubleBounce())
                    binding.spinner5.setIndeterminateDrawable(DoubleBounce())*/
                }
                is Resource.Success -> {
                    myAdapter.setList(result.value)
                    binding.spinner.visibility = View.GONE
                    binding.spinner2.visibility = View.GONE
                    binding.spinner3.visibility = View.GONE
                    binding.spinner4.visibility = View.GONE
                    binding.spinner5.visibility = View.GONE
                }

            }

        })
    }

    private fun setUpRecycler() {



    }

    override fun itemClickListener(dataClass: DataClasses) {
//        Toast.makeText(this, dataClass, Toast.LENGTH_LONG).show()

        when(dataClass){
            is DataClasses.Joke -> {
                Toast.makeText(this, dataClass.punchline, Toast.LENGTH_LONG).show()
            }
        }
    }


}