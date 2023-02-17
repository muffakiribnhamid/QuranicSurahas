package com.example.quranicsurahas.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://api.quran.com/api/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
     val apiinterface by lazy {
        retrofit.create(apiInterface::class.java)
    }


}