package com.example.androidarchitecturedemo.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.androidarchitecturedemo.MainActivity
import com.example.androidarchitecturedemo.R

class LifeCycleAwareComponents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_aware_components)
        lifecycle.addObserver(LifeCycleObserver())
        Log.d("TAG", "Activity created")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "Activity onRestart")
    }

    fun lifeCycleComponents(view: View) {
        startActivity(Intent(this,MainActivity::class.java))
    }
}