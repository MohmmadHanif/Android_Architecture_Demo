package com.example.androidarchitecturedemo.mvvm_demo.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecturedemo.mvvm_demo.MVVMQuotesDataClass
import com.example.androidarchitecturedemo.mvvm_demo.repository.MVVMRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MVVMMainViewModal(val repository:MVVMRepository) :ViewModel() {

    fun getAllData(): LiveData<List<MVVMQuotesDataClass>> {
        return repository.getAllQuotes()
    }

    fun insert(quotes:MVVMQuotesDataClass) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertQuotes(quotes)
        }
    }
}