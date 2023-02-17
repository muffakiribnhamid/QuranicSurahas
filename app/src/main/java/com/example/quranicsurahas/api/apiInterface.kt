package com.example.quranicsurahas.api

import com.example.quranicsurahas.models.AboutModel
import com.example.quranicsurahas.models.SurahModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface apiInterface {

    @GET("chapters?language=en")
    fun getData() : Call<SurahModel>
    @GET("chapters/{id}/info?language=en")
    fun getInfo(@Path("id")id : String) : Call<AboutModel>
}