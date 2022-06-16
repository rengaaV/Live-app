package com.vagner.live

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vagner.live.adapters.LiveAdapte
import com.vagner.live.databinding.ActivityLiveBinding
import com.vagner.live.models.LiveItem
import com.vagner.live.viewmodel.LiveViewModel

class LiveActivity : AppCompatActivity() {

    val TAG = "TAG"

    val adapterLive = LiveAdapte {
        openLink(it.link)
    }


    lateinit var viewModel: LiveViewModel

    private lateinit var binding: ActivityLiveBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveBinding.inflate(layoutInflater)
        setContentView(binding.root)






        viewModel = ViewModelProvider(this).get(LiveViewModel::class.java)

        binding.recyclerview.adapter = adapterLive
    }

    override fun onStart() {
        super.onStart()

        viewModel.liveList.observe(this, Observer {


            Log.d(TAG, "onStart : $it")
            adapterLive.lives = it

        })


        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

    }

    override fun onResume() {
        super.onResume()

        viewModel.getAllLives()
    }


    private fun openLink(link: String) {

        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)

    }

}