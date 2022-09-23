package com.example.androidarchitecturedemo.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner


class LifeCycleObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("TAG", " Observer - onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d("TAG", " Observer - onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.d("TAG", " Observer - onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("TAG", " Observer - onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.d("TAG", " Observer - onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("TAG", " Observer - onDestroy")
    }

}