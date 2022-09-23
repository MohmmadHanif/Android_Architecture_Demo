package com.example.androidarchitecturedemo.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.databinding.ActivityLivedataMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LivedataMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLivedataMainBinding
    lateinit var liveDataViewModal: LiveDataViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLivedataMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        liveDataViewModal = ViewModelProvider(this).get(LiveDataViewModal::class.java)

        liveDataViewModal.factsLiveData.observe(this){
            binding.liveDataCount.text = it.toString()
        }

        binding.incrementLivedata.setOnClickListener(){
            CoroutineScope(Dispatchers.Main).launch {
                liveDataViewModal.increment()
            }
        }
    }
}