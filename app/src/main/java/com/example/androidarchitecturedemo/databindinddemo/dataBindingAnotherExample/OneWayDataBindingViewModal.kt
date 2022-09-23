package com.example.androidarchitecturedemo.databindinddemo.dataBindingAnotherExample

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OneWayDataBindingViewModal : ViewModel() {

    var quotes = MutableLiveData<String>()
    val userBonusNumber = MutableLiveData<String>()


    fun change() {
        quotes.value = userBonusNumber.value
//        quotes.value = "Jahan Yaqeen Ho Wahan Shak Nahin Kiya Karte"
        Log.d("TAG", "change: ${quotes.value}")
    }
}