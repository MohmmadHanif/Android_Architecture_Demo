package com.example.androidarchitecturedemo.viewmodaldemo

import androidx.lifecycle.ViewModel

class MainViewModal(val startingCounter:Int) : ViewModel() {

    var count = startingCounter

    fun increment(){
        count++
    }
}