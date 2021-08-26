package com.example.tools2.retrofit

import com.example.tools2.model.DataClasses
import retrofit2.http.GET

interface MyRequest {

    @GET("random_ten/")
    suspend fun getJoke(): List<DataClasses.Joke>
}