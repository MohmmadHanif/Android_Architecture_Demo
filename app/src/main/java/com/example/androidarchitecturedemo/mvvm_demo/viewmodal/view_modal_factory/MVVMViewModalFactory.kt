package com.example.androidarchitecturedemo.mvvm_demo.viewmodal.view_modal_factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecturedemo.mvvm_demo.repository.MVVMRepository
import com.example.androidarchitecturedemo.mvvm_demo.viewmodal.MVVMMainViewModal

class MVVMViewModalFactory(val repository:MVVMRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMMainViewModal(repository) as T
    }
}