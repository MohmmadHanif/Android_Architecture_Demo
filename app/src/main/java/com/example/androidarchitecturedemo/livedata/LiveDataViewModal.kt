package com.example.androidarchitecturedemo.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class LiveDataViewModal : ViewModel() {
    val factsLiveData = MutableLiveData<Int>(1)


    suspend fun increment() {

        val job = CoroutineScope(Dispatchers.Main).launch {
            delay(5000)
            factsLiveData.value = 2
        }
        job.join()

        val job1 = CoroutineScope(Dispatchers.Main).launch {
            delay(5000)
            factsLiveData.value = 3
        }
        job1.join()
        withContext(Dispatchers.IO) {
            delay(5000)
        }

        for (i in 2..10){
            withContext(Dispatchers.Main){
                delay(5000)
                factsLiveData.value = i
            }
        }

    }
}