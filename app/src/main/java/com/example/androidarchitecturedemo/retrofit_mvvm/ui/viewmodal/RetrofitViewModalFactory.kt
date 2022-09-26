package com.example.androidarchitecturedemo.retrofit_mvvm.ui.viewmodal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.retrofit_mvvm.repository.RetrofitRepository

class RetrofitViewModalFactory(val repository: RetrofitRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RetrofitViewModal(repository) as T
    }
}