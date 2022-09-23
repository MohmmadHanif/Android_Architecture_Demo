package com.example.androidarchitecturedemo.viewmodaldemo

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.androidarchitecturedemo.R
import com.example.androidarchitecturedemo.databinding.ActivityViewModalMainBinding

class ViewModalMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewModalMainBinding
    lateinit var mainViewModal:MainViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModalMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.count.text = mainViewModal.count.toString()
        mainViewModal = ViewModelProvider(this,MainViewModalFactory(10)).get(MainViewModal::class.java)
        binding.increment.setOnClickListener(){
            mainViewModal.increment()
            binding.count.text = mainViewModal.count.toString()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        binding.count.text = mainViewModal.count.toString()
    }
}