package com.example.tools2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tools2.model.DataClasses
import com.example.tools2.repository.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import net.simplifiedcoding.multiviewlist.data.network.Resource

class HomeViewModel(private val repository: Repository) : ViewModel() {

    val homeList = MutableLiveData<Resource<List<DataClasses>>>()


    init {
        getHomeListItems()
    }

    private fun getHomeListItems() {
        viewModelScope.launch {

            val reallyJoke = async { repository.getJoke() }
            val joke = reallyJoke.await()

            val itemList = mutableListOf<DataClasses>()

            if (joke is Resource.Success){
                itemList.addAll(joke.value)
                homeList.postValue(Resource.Success(itemList))
            }else{
                Resource.Failure(false, null, null)
            }
        }


    }

}