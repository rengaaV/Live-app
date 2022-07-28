package com.vagner.live.repository

import com.vagner.live.webservice.RetrofitService

class LiveRepository(private val retrofitService : RetrofitService) {
        fun getAllLives() = retrofitService.getLive()
}