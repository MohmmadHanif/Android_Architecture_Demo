package com.example.androidarchitecturedemo.viewmodaldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModalFactory( val counter:Int) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModal(counter) as T
    }

}