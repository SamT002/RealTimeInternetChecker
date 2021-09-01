package com.example.tools2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tools2.repository.Repository
import com.example.tools2.retrofit.MyRequest

class MyViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(Repository(MyRequest::class.java)) as T
        }
        throw IllegalArgumentException("Unknown Class from Factory")
    }
}