package com.vagner.live.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vagner.live.repository.LiveRepository

class LiveViewModelFactory(private val repository: LiveRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return if (modelClass.isAssignableFrom(LiveViewModel::class.java)){
           LiveViewModel(this.repository) as T
       }else{
           throw IllegalArgumentException("ViewModel Not Found")
       }
    }


}