package com.example.tools2.retrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyClient {

    private lateinit var retrofit: Retrofit

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    fun <MyRequest> buildApi(
        api: Class<com.example.tools2.retrofit.MyRequest>
    ): com.example.tools2.retrofit.MyRequest {
        return Retrofit.Builder()
                .baseUrl("https://official-joke-api.appspot.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)

    }
}