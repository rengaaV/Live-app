package com.vagner.live.webservice

import com.vagner.live.models.LiveItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitService {

    @GET("lista-lives.json")
    fun getLive() : Call<List<LiveItem>>


}