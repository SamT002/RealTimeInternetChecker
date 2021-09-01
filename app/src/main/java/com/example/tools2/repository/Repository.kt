package com.example.tools2.repository

import com.example.tools2.model.SafeApiCall
import com.example.tools2.retrofit.MyClient
import com.example.tools2.retrofit.MyRequest

class Repository(private val request: Class<MyRequest>):SafeApiCall {

    suspend fun getJoke() = safeApiCall { MyClient.buildApi<MyRequest>(request).getJoke() }

}