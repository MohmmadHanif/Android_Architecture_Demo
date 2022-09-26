package com.example.androidarchitecturedemo.retrofit_mvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitecturedemo.retrofit_mvvm.dataclass.SimpleJsonDataClassItem
import com.example.androidarchitecturedemo.retrofit_mvvm.network.Network

class RetrofitRepository(val repository: Network) {

    val mutableLivedata = MutableLiveData<SimpleJsonDataClassItem>()

    val getData: LiveData<SimpleJsonDataClassItem>
        get() = mutableLivedata

    suspend fun getDatas() {
        val result = repository.getData()

        if (result.body() != null) {
            mutableLivedata.postValue(result.body())
        }else{
            Log.d("TAG", "getDatas: body null")
        }
    }
}