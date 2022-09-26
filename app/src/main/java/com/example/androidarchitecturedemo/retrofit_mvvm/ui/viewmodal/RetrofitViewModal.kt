package com.example.androidarchitecturedemo.retrofit_mvvm.ui.viewmodal

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecturedemo.retrofit_mvvm.dataclass.SimpleJsonDataClassItem
import com.example.androidarchitecturedemo.retrofit_mvvm.repository.RetrofitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RetrofitViewModal(val repository: RetrofitRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getDatas()
        }
    }
    val apiResponce:LiveData<SimpleJsonDataClassItem> = repository.getData

}