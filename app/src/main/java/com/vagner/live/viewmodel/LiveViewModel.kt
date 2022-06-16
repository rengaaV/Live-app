package com.vagner.live.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vagner.live.models.LiveItem
import com.vagner.live.webservice.StartRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveViewModel() : ViewModel() {

    private val repository by lazy { StartRetrofit.init() }
    val liveList = MutableLiveData<List<LiveItem>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllLives(){
       repository.getLive().enqueue(object : Callback<List<LiveItem>>{
           override fun onResponse(call: Call<List<LiveItem>>, response: Response<List<LiveItem>>) {
               liveList.postValue(response.body())
           }

           override fun onFailure(call: Call<List<LiveItem>>, t: Throwable) {
               errorMessage.postValue(t.message)
           }

       })
    }
}