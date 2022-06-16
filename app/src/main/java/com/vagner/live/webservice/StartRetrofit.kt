package com.vagner.live.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object StartRetrofit {

    fun init () : RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://d3c0cr0sze1oo6.cloudfront.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}