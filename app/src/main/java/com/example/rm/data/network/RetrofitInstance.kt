package com.example.rm.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://rickandmortyapi.com/"

object RetrofitInstance {
    private val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api: ApiService by lazy {
        instance.create(ApiService::class.java)
    }
}
