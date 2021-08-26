package com.example.tools2.repository

import com.example.tools2.model.SafeApiCall
import com.example.tools2.retrofit.MyClient
import com.example.tools2.retrofit.MyRequest

class Repository():SafeApiCall {

    suspend fun getJoke() = safeApiCall { MyClient.buildApi<MyRequest>(MyRequest::class.java).getJoke() }

}